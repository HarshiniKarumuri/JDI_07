package com.flipkart.bean;

import java.sql.Timestamp;

/**
 * @author harshini
 */
public class Payment {

    private int paymentId;
    private int feesPaid;
    private String paymentMode;
    private Timestamp paymentTime;

    /**
     * gets the payment Id of the payment
     *
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * sets the payment Id of the payment
     *
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * get the fees paid
     *
     * @return the feesPaid
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * set the fees paid
     *
     * @param feesPaid the feesPaid to set
     */
    public void setFeesPaid(int feesPaid) {
        this.feesPaid = feesPaid;
    }

    /**
     * get the payment time
     *
     * @return the paymentDate
     */
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    /**
     * set the payment time
     *
     * @param paymentTime the paymentDate to set
     */
    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    /**
     * get the mode of the payment
     *
     * @return the mode of the payment
     */
    public String getPaymentMode() {
        return paymentMode;
    }

    /**
     * set the mode of the payment
     *
     * @param paymentMode the mode of the payment
     */
    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return String.format("\n%-15s%-15s%-15s%-15s", "Date/Time", "Payment ID", "Payment Mode", "Amount Paid\n") +
                String.format("%-15s%-15s%-15s%-15s", paymentTime, paymentId, paymentMode, feesPaid);
    }
}
