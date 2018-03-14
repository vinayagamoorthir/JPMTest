package com.test.jpmorgan.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Test {

	/*public static void main(String[] args) {

		double exchangeRate = 0.2012;
		double amount = 40000;
		double usdExchangeRate = 0.161;
		double amountInUsd = usdExchangeRate * amount;
		System.out.println(value(amountInUsd, 2));
		double finalRate = (value(exchangeRate, 4)*(1- 0.4/100));
		
		System.out.println(value(finalRate, 4));
		double profile = value((value(exchangeRate, 4) -value(finalRate, 4))* value(amount, 2), 2);
		System.out.println(value(profile, 2));
	}

	public static float value(double currentValue, int decimals) {
		BigDecimal value = new BigDecimal(currentValue);
		value = value.setScale(decimals, RoundingMode.HALF_EVEN);
		return value.floatValue(); 
	}
	*/
	public static void main(String[] args) {
        String text = "500.01";
        double number = Double.parseDouble(text);

        DecimalFormat format = new DecimalFormat("0.00");
        String formatted = format.format(number);
        System.out.println(formatted);
    }

}
