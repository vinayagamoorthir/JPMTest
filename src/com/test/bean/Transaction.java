package com.test.jpmorgan.bean;

public class Transaction {

	private String baseCurrency;
	private String wantedCurrency;
	private String amountInBaseCurrency;
	private String clientType;
	private String transactionTime;

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public String getWantedCurrency() {
		return wantedCurrency;
	}

	public void setWantedCurrency(String wantedCurrency) {
		this.wantedCurrency = wantedCurrency;
	}

	public String getAmountInBaseCurrency() {
		return amountInBaseCurrency;
	}

	public void setAmountInBaseCurrency(String amountInBaseCurrency) {
		this.amountInBaseCurrency = amountInBaseCurrency;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	@Override
	public String toString() {
		return baseCurrency + " " + wantedCurrency + " " + amountInBaseCurrency
				+ " " + clientType + " " + transactionTime +"\n";
	}

}
