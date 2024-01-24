package com.ohgiraffers.section02.userexception;

public class MoneyNegativeException extends Exception {
    public MoneyNegativeException(String message) {
        super(message);
    }
}
