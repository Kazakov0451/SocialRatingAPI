package com.example.socialratingapi.exception;

public abstract class MCCException extends RuntimeException {

    /**
     * Базовое исключение приложения
     *
     * @param message Информация об исключении
     */
    public MCCException(String message) {
        super(message);
    }
}
