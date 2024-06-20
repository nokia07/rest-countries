package com.creamos.usecase.country;

import com.creamos.model.country.Country;
import com.creamos.model.country.gateways.CountryGateway;
import com.creamos.model.country.gateways.CountryRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CountryUseCase {
    private final CountryRepository countryRepository;
    private final CountryGateway countryGateway;
    public Mono<Country> findByName(String name) {
        return countryRepository.findByName(name);
    }

    public Mono<Country> findByNameFromApi(String name) {
        return countryGateway.findByName(name);
    }
}
