package com.flipkart.exception;

public class PaymentFailedException extends Exception{
    @Override
    public String getMessage() {
        return "Payment unsuccessful. Please try again\n";
    }
}
