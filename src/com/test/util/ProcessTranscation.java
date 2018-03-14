package com.test.jpmorgan.util;

import java.util.List;

import com.test.jpmorgan.bean.Rates;
import com.test.jpmorgan.bean.Transaction;
import com.test.jpmorgan.bean.TransactionResult;

public class ProcessTranscation {

	private CurrencyConverter converter;
	private FeeCalculator feeCalulator;

	public ProcessTranscation() {
		converter = new CurrencyConverter();
		feeCalulator = new FeeCalculator();
	}

	public TransactionResult process(Transaction transaction, List<Rates> rates)
			throws Exception {

		String baseCurrency = transaction.getBaseCurrency();
		String wantedCurrency = transaction.getWantedCurrency();
		String clientType = transaction.getClientType();
		String transactionTime = transaction.getTransactionTime();

		double amountInBaseCurrency = Double.parseDouble(transaction
				.getAmountInBaseCurrency());

		double amountInUSD = converter.getCurrencyInUSD(rates, baseCurrency,
				amountInBaseCurrency, transactionTime);

		double rate = converter.getRequiredRate(rates, baseCurrency,
				wantedCurrency, transactionTime);

		long fees = feeCalulator.getFee(clientType, amountInUSD);

		double finalRate = converter.getFinalRateValue(rate, fees);

		double profitInWantedCurrency = converter.getProfit(
				amountInBaseCurrency, rate, finalRate);

		double profitInSGD = converter.getProfitInSGD(rates, wantedCurrency,
				profitInWantedCurrency, transactionTime);

		TransactionResult result = new TransactionResult();

		result.setBaseCurrency(baseCurrency);
		result.setWantedCurrency(wantedCurrency);
		result.setAmountInBaseCurrency(Double.toString(amountInBaseCurrency));
		result.setClientType(clientType);
		result.setTransactionTime(transactionTime);

		result.setStandardRate(Double.toString(rate));
		result.setFinalRate(Double.toString(finalRate));
		result.setProfitInWantedCurrency(Double
				.toString(profitInWantedCurrency));

		result.setProfitInSGD(Double.toString(profitInSGD));

		return result;

	}

}
