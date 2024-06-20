package com.creamos.model.country;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Country {
    private Integer id;
    private String name;
    private String capital;
    private String currency;
    private Double population;
}
