package com.creamos.model.country.gateways;

import com.creamos.model.country.Country;
import reactor.core.publisher.Mono;

public interface CountryRepository {

    Mono<Country> findByName(String name);
}
