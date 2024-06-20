package com.creamos.jpa;

import com.creamos.jpa.entity.CountryData;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CountryDataRepository extends CrudRepository<CountryData, Integer>, QueryByExampleExecutor<CountryData> {
    CountryData findByName(String name);
}
