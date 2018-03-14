package com.test.jpmorgan.bean;

public class Rates {

	private String baseCurrency;
	private String wantedCurrency;
	private String rate;
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

	public String getTransactionTime() {
		return transactionTime;
	}

	public void setTransactionTime(String transactionTime) {
		this.transactionTime = transactionTime;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}
	
	@Override
	public String toString() {
		return baseCurrency + " " + wantedCurrency + " " + rate + " " + transactionTime 
				+ "\n";
	}

}
