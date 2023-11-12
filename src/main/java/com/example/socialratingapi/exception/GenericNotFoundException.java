package com.example.socialratingapi.exception;

public class GenericNotFoundException extends NotFoundException {
    /**
     * Общее для всех "Не найден" исключение
     *
     * @param id    Идентификатор искомой сущности
     * @param clazz Искомый класс
     */
    public GenericNotFoundException(Long id, Class<?> clazz) {
        super(String.format("Сущность %s с идентификатором %s не найдена", clazz.getCanonicalName(), id));
    }
}
