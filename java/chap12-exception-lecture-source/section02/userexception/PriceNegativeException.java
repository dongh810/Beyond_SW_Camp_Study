package com.ohgiraffers.section02.userexception;

public class PriceNegativeException extends Exception {
    public PriceNegativeException(String message) {
        super(message);
    }
}
