package com.willner.mist_gaming_store.exception;

public class TransientEntityException extends IllegalArgumentException {
    public TransientEntityException(String message) {
        super(message);
    }
}
