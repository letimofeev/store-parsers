package com.storeparser.microservice.componentservice.utils;

import java.lang.reflect.Field;

public class NullValuesResolver<T> {

    private boolean isModified;
    private final T element;
    private final Class<T> requiredType;

    public NullValuesResolver(T element, Class<T> requiredType) {
        this.requiredType = requiredType;
        this.element = element;
    }

    public boolean isModified() {
        return isModified;
    }

    public T getElement() {
        return element;
    }

    public void merge(T otherElement) {
        for (Field field : requiredType.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                if (field.get(element) == null && field.get(otherElement) != null) {
                    isModified = true;
                    field.set(element, field.get(otherElement));
                } else if (field.getType() == int.class &&
                        field.getInt(element) == 0 && field.getInt(otherElement) != 0) {
                    isModified = true;
                    field.set(element, field.getInt(otherElement));
                }
            } catch (IllegalAccessException e) {
                throw new NullValuesResolverException(String.format(
                        "Exception during merging objects with type: %s; nested exception: %s",
                        requiredType, e.getCause()), e);
            }
        }
    }
}
