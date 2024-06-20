package com.creamos.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class CountryDTO {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer id;
    private String name;
    private String capital;
    private String currency;
    private Double population;

}
