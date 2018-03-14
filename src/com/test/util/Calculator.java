package com.test.jpmorgan.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator {

	public double getAppliedExchangeRate(double amount, double exhangeRate) {
		double appliedExchangeRate = value(
				value(amount, 2) * value(exhangeRate, 4), 2);
		return appliedExchangeRate;
	}

	public double getFinalRateValue(double exchangeRate, long fee) {
		double feeInPercentage = value(fee,4) / 100;
		double finalRate = (value(exchangeRate, 4) * (1 - value(
				feeInPercentage, 4) / 100));
		return finalRate;
	}

	public double getProfit(double amount, double exchangeRate, double finalRate) {
		double profit = value((value(exchangeRate, 4) - value(finalRate, 4))
				* value(amount, 2), 2);
		return profit;
	}

	private float value(double currentValue, int decimals) {
		BigDecimal value = new BigDecimal(currentValue);
		value = value.setScale(decimals, RoundingMode.HALF_UP);
		return value.floatValue();
	}
}
