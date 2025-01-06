package com.willner.mist_gaming_store.exception;

public class InsuficientStockException extends RuntimeException {
    public InsuficientStockException(String message) {
        super(message);
    }
}
