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
     * @return the paymentId
     */
    public int getPaymentId() {
        return paymentId;
    }

    /**
     * @param paymentId the paymentId to set
     */
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    /**
     * @return the feesPaid
     */
    public int getFeesPaid() {
        return feesPaid;
    }

    /**
     * @param feesPaid the feesPaid to set
     */
    public void setFeesPaid(int feesPaid) {
        this.feesPaid = feesPaid;
    }

    /**
     * @return the paymentDate
     */
    public Timestamp getPaymentTime() {
        return paymentTime;
    }

    /**
     * @param paymentTime the paymentDate to set
     */
    public void setPaymentTime(Timestamp paymentTime) {
        this.paymentTime = paymentTime;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return String.format("\n%-15s%-15s%-15s%-15s", "Date/Time", "Payment ID", "Payment Mode", "Amount Paid\n") +
                String.format("%-15s%-15s%-15s%-15s", paymentTime, paymentId, paymentMode, feesPaid);
    }
}
