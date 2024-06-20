package com.creamos.api;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/public")
public class HealthCheckService {
    @GetMapping(path = "/health", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Boolean> check() {
        return Mono.just(Boolean.TRUE);
    }
}
