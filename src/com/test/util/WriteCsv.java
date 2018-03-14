package com.test.util;

import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;

import com.test.jpmorgan.bean.TransactionResult;

public class WriteCsv {

	
	public void writeCsvFile(List<TransactionResult> result) throws Exception {
		 FileWriter writer = new FileWriter("c:\\expected-output.csv");
		 
		 DecimalFormat rateFormat = new DecimalFormat("0.0000");
		 DecimalFormat amountFormat = new DecimalFormat("0.00");
		 
		    writer.append("BaseCurrency,WantedCurrency,AmountInBaseCurrency,StandardRate,FinalRate,ProfitInWantedCurrency,ProfitInSGD");
		    writer.append('\n');
		    for (TransactionResult transactionResult : result) {
		    	writer.append(transactionResult.getBaseCurrency()+",");
		    	writer.append(transactionResult.getWantedCurrency()+",");
		    	writer.append(transactionResult.getAmountInBaseCurrency()+",");
		    	writer.append(rateFormat.format(Double.parseDouble(transactionResult.getStandardRate()))+",");
		    	writer.append(rateFormat.format(Double.parseDouble(transactionResult.getFinalRate()))+",");
		    	writer.append(amountFormat.format(value(Double.parseDouble(transactionResult.getProfitInWantedCurrency()), 2))+",");
		    	writer.append(amountFormat.format(value(Double.parseDouble(transactionResult.getProfitInSGD()), 2))+"\n");
		    }
		    writer.flush();
		    writer.close();
	}
	
	private float value(double currentValue, int decimals) {
		BigDecimal value = new BigDecimal(currentValue);
		value = value.setScale(decimals, RoundingMode.HALF_EVEN);
		return value.floatValue();
	}
}
