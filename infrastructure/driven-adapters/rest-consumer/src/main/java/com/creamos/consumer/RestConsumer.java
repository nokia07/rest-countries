package com.creamos.consumer;

import com.creamos.model.country.Country;
import com.creamos.model.country.gateways.CountryGateway;
import com.fasterxml.jackson.databind.JsonNode;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Iterator;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RestConsumer implements CountryGateway {
    private final WebClient client;
    @Override
    @CircuitBreaker(name = "countryGet" /*, fallbackMethod = "testGetOk"*/)
    public Mono<Country> findByName(String countryName) {
        return client
                .get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v3.1/name/{countryName}")
                        .build(countryName))
                .retrieve()
                .bodyToFlux(JsonNode.class)
                .next()
                .map(jsonNode -> {
                    String currency = "-";
                    Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.get("currencies").fields();
                    if (fields.hasNext()) {
                        Map.Entry<String, JsonNode> firstEntry = fields.next();
                        currency = firstEntry.getKey();
                    }
                    return Country.builder()
                            .name(jsonNode.get("name").get("common").asText())
                            .capital(jsonNode.get("capital").get(0).asText())
                            .currency(currency)
                            .population(jsonNode.get("population").asDouble())
                            .build();
                })
                .onErrorResume(ex -> {
                    if (ex instanceof WebClientResponseException) {
                        WebClientResponseException httpEx = (WebClientResponseException) ex;
                        if (httpEx.getStatusCode() == HttpStatus.NOT_FOUND) {
                            return Mono.empty();
                        }
                    }
                    return Mono.error(ex);
                });
    }
}
