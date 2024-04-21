package com.example.entity;

public interface PrimaryEntity<T> {

    T getId();

    void setId(T id);
}