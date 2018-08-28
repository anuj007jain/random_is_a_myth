package com.Repeat_Practice;

/**
 * Created by anuj.jain02 on 1/9/17.
 */
public final class ImmutableClass {

    final private String data;

    public ImmutableClass(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}
