package com.flipkart.bean;

import java.sql.Date;

/**
 * @author harshini
 *
 */
public class Payment {

	private int paymentId;
	private float feesPaid;
	private Date paymentDate;

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
	public float getFeesPaid() {
		return feesPaid;
	}

	/**
	 * @param feesPaid the feesPaid to set
	 */
	public void setFeesPaid(float feesPaid) {
		this.feesPaid = feesPaid;
	}

	/**
	 * @return the paymentDate
	 */
	public Date getPaymentDate() {
		return paymentDate;
	}

	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	
	

}
