package com.test.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.test.jpmorgan.bean.Rates;

public class CurrencyConverter {

	private Calculator calc;

	public CurrencyConverter() {
		calc = new Calculator();
	}

	public double getCurrencyInUSD(List<Rates> rates, String baseCurrency,
			double amount, String transactTime) throws Exception {
		double requiredRate = getRequiredRate(rates, baseCurrency, "USD",
				transactTime);
		double amountInUsd = calc.getAppliedExchangeRate(amount, requiredRate);
		return amountInUsd;
	}

	public double getProfitInSGD(List<Rates> rates, String baseCurrency,
			double amount, String transactTime) throws Exception {

		if (baseCurrency.equalsIgnoreCase("SGD")) {
			return amount;
		}

		double requiredRate = getRequiredRate(rates, baseCurrency, "SGD",
				transactTime);

		double amountInSgd = calc.getAppliedExchangeRate(amount, requiredRate);

		return amountInSgd;
	}

	public double getRequiredRate(List<Rates> rates, String baseCurrency,
			String reqCurrency, String transactTime) throws Exception {
		Rates reqRate = null;
		sortDates(rates);
		for (Rates rate : rates) {
			if (rate.getBaseCurrency().equalsIgnoreCase(baseCurrency)
					&& rate.getWantedCurrency().equalsIgnoreCase(reqCurrency)
					&& DateUtil.isDateMatched(transactTime,
							rate.getTransactionTime())) {
				reqRate = rate;
				break;
			}
		}

		return Double.parseDouble(reqRate.getRate());

	}
	
	private void sortDates(List<Rates> rates ) throws Exception{
		Collections.sort(rates, new Comparator<Rates>() {
		    public int compare(Rates r1, Rates r2) {
		    	try {
		    		return DateUtil.compare(r1.getTransactionTime(), r2.getTransactionTime());
				} catch (Exception e) {
					return -1;
				}
		    }
		});
	}

	public double getFinalRateValue(double exchangeRate, long fee) {
		return calc.getFinalRateValue(exchangeRate, fee);
	}

	public double getProfit(double amount, double exchangeRate, double finalRate) {
		return calc.getProfit(amount, exchangeRate, finalRate);
	}
}
