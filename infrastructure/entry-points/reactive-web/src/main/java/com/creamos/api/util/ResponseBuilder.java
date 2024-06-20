package com.creamos.api.util;
import com.creamos.api.dto.ResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface ResponseBuilder {

    default <T> ResponseEntity<ResponseDTO<T>> build200Response(T data) {
        return ResponseEntity.ok(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message(EnumMessage.Message.MESSAGE200.getMessage())
                        .status(200)
                        .data(data)
                        .build());
    }

    default <T> ResponseEntity<ResponseDTO<T>> build201Response(T data) {
        return ResponseEntity.ok(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message(EnumMessage.Message.MESSAGE201.getMessage())
                        .status(201)
                        .data(data)
                        .build());
    }

    default <T> ResponseEntity<ResponseDTO<T>> build404Response() {
        return ResponseEntity.status(404).body(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message(EnumMessage.Message.MESSAGE404.getMessage())
                        .status(404)
                        .build());

    }

    default <T> ResponseEntity<ResponseDTO<T>> build401Response() {
        return ResponseEntity.status(401).body(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message(EnumMessage.Message.MESSAGE401.getMessage())
                        .status(401)
                        .build());
    }

    default <T> ResponseEntity<ResponseDTO<T>> build500Response(String exception) {
        return ResponseEntity.status(500).body(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message(exception)
                        .error(EnumMessage.Message.MESSAGE500.getMessage())
                        .status(500)
                        .build());
    }

    default <T> ResponseEntity<ResponseDTO<T>> build400Response(String exception) {
        return ResponseEntity.status(400).body(
                ResponseDTO.<T>builder()
                        .transactionId(UUID.randomUUID().toString())
                        .message(exception)
                        .error(EnumMessage.Message.MESSAGE400.getMessage())
                        .status(400)
                        .build());
    }
}
