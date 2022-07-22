package com.storeparser.microservice.componentservice.service;

import java.lang.reflect.Field;

public class NullValuesResolver<T> {

    private boolean isModified;
    private final T element;
    private final Class<T> requiredType;

    public NullValuesResolver(T element, Class<T> requiredType) {
        this.requiredType = requiredType;
        this.element = element;
    }

    public void merge(T otherElement) {
        for (Field field : requiredType.getDeclaredFields()) {
            try {
                field.setAccessible(true);
                Object firstElementField = field.get(element);
                Object secondElementField = field.get(otherElement);
                if (firstElementField == null && secondElementField != null) {
                    isModified = true;
                    field.set(element, secondElementField);
                }
            } catch (IllegalAccessException e) {
                throw new NullValuesResolverException(String.format(
                        "Exception during merging objects with type: %s; nested exception: %s",
                        requiredType, e.getCause()), e);
            }
        }
    }

    public boolean isModified() {
        return isModified;
    }

    public T getElement() {
        return element;
    }
}
