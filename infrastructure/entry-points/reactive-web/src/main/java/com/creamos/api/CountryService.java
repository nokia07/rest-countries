package com.creamos.api;

import com.creamos.api.dto.CountryDTO;
import com.creamos.api.dto.ResponseDTO;
import com.creamos.api.util.ResponseBuilder;
import com.creamos.model.country.Country;
import com.creamos.model.country.gateways.CountryGateway;
import com.creamos.usecase.country.CountryUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/countries")
@AllArgsConstructor
public class CountryService  implements ResponseBuilder {

    private final CountryUseCase countryUseCase;

    @GetMapping(path = "/v1.0/name/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<ResponseDTO<CountryDTO>>> searchByName(@PathVariable("countryName") String countryName) {
        return countryUseCase.findByName(countryName)
                .map(country ->
                        CountryDTO.builder()
                            .name(country.getName())
                            .capital(country.getCapital())
                            .currency(country.getCurrency())
                            .population(country.getPopulation())
                            .build())
                .map(this::build200Response)
                .switchIfEmpty(Mono.just(build404Response()))
                .onErrorResume(ex -> Mono.just(build500Response(ex.getMessage())));
    }

    @GetMapping(path = "/v1.1/name/{countryName}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<ResponseEntity<ResponseDTO<CountryDTO>>> searchByNameFromApi(@PathVariable("countryName") String countryName) {
        return countryUseCase.findByNameFromApi(countryName)
                .map(country ->
                        CountryDTO.builder()
                                .name(country.getName())
                                .capital(country.getCapital())
                                .currency(country.getCurrency())
                                .population(country.getPopulation())
                                .build())
                .map(this::build200Response)
                .switchIfEmpty(Mono.just(build404Response()))
                .onErrorResume(ex -> Mono.just(build500Response(ex.getMessage())));
    }
}
