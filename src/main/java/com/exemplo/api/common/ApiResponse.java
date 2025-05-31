package com.exemplo.api.common;

import java.time.LocalDateTime;

/**
 * Classe utilitária para padronizar as respostas da API
 * @param <T> tipo do dado retornado
 */
public class ApiResponse<T> {
    private T data;
    private String message;
    private LocalDateTime timestamp;
    private boolean success;

    public ApiResponse(T data) {
        this.data = data;
        this.success = true;
        this.timestamp = LocalDateTime.now();
    }

    public ApiResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
        this.timestamp = LocalDateTime.now();
    }

    // Métodos estáticos utilitários
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(data);
    }

    public static ApiResponse<Void> error(String message) {
        return new ApiResponse<>(message, false);
    }

    // Getters e Setters
    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public boolean isSuccess() {
        return success;
    }
}