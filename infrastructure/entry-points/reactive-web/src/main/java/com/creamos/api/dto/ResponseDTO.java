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
public class ResponseDTO<T> {

    private String transactionId;
    private Integer status;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T data;

}
