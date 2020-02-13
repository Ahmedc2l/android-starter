package com.ahmedc2l.userauthstarter.socialAuthProviders;

/**
 * <h1>GenericData</h1>
 * <p>This is a generic class to handle all types of objects.</p>
 *
 * @author Ahmed Fathy
 * @since 22-Jul-2019
 * @version 1.0
 * */
public class GenericData<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}