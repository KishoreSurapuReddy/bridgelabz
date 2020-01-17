package com.bridgelabz.stockmanagement;

import java.util.Arrays;

public class CustomerStockAccount {

	String customerName;
	int customerId;
	String[] stockName;
	int[] numberOfShares;
	double[] shareValue;

	public CustomerStockAccount() {

	}

	public CustomerStockAccount(String customerName, int customerId, String[] stockName, int[] numberOfShares,
			double[] shareValue) {

		this.customerName = customerName;
		this.customerId = customerId;
		this.stockName = stockName;
		this.numberOfShares = numberOfShares;
		this.shareValue = shareValue;
	}

	public String[] getStockName() {
		return stockName;
	}

	public void setStockName(String[] stockName) {
		this.stockName = stockName;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int[] getNumberOfShares() {
		return numberOfShares;
	}

	public void setNumberOfShares(int[] numberOfShares) {
		this.numberOfShares = numberOfShares;
	}

	public double[] getShareValue() {
		return shareValue;
	}

	public void setShareValue(double[] shareValue) {
		this.shareValue = shareValue;
	}

	@Override
	public String toString() {
		return "CustomerStockAccount [customerName=" + customerName + ", customerId=" + customerId + ", stockName="
				+ Arrays.toString(stockName) + ", numberOfShares=" + Arrays.toString(numberOfShares) + ", shareValue="
				+ Arrays.toString(shareValue) + "]";
	}

}
