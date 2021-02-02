package com.flipkart.exception;

public class PaymentFailedException extends Exception{
    @Override
    public String getMessage() {
<<<<<<< HEAD
        return "Payment unsuccessful. Please try again";
=======
        return "Payment unsuccessful. Please try again\n";
>>>>>>> 0c649c6c9c7d5d757bbcc6c2f9acb13b19c7f3fb
    }
}
