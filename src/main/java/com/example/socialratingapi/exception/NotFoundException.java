package com.example.socialratingapi.exception;

public abstract class NotFoundException extends MCCException {

    /**
     * Общее для всех "Не найден" исключение
     *
     * @param message Информация об исключении
     */
    public NotFoundException(String message) {
        super(message);
    }
}
