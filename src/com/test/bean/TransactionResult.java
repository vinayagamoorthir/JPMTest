package com.test.bean;

public class TransactionResult extends Transaction {

	private String standardRate;
	private String finalRate;
	private String profitInWantedCurrency;
	private String profitInSGD;

	public String getStandardRate() {
		return standardRate;
	}

	public void setStandardRate(String standardRate) {
		this.standardRate = standardRate;
	}

	public String getFinalRate() {
		return finalRate;
	}

	public void setFinalRate(String finalRate) {
		this.finalRate = finalRate;
	}

	public String getProfitInWantedCurrency() {
		return profitInWantedCurrency;
	}

	public void setProfitInWantedCurrency(String profitInWantedCurrency) {
		this.profitInWantedCurrency = profitInWantedCurrency;
	}

	public String getProfitInSGD() {
		return profitInSGD;
	}

	public void setProfitInSGD(String profitInSGD) {
		this.profitInSGD = profitInSGD;
	}

}
