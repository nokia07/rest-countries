package com.creamos.jpa;

import com.creamos.jpa.entity.CountryData;
import com.creamos.jpa.helper.AdapterOperations;
import com.creamos.model.country.Country;
import com.creamos.model.country.gateways.CountryRepository;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public class CountryRepositoryAdapter extends AdapterOperations<Country, CountryData, Integer, CountryDataRepository>
        implements CountryRepository {

    public CountryRepositoryAdapter(CountryDataRepository repository, ObjectMapper mapper) {
        super(repository, mapper, d -> mapper.map(d, Country.class));
    }

    @Override
    public Mono<Country> findByName(String name) {
        return Mono.justOrEmpty(repository.findByName(name))
                .map(countryData -> mapper.map(countryData, Country.class));
    }
}
