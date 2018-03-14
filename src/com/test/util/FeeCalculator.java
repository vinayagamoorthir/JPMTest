package com.test.jpmorgan.util;

public class FeeCalculator {

	public long getFee(String clientType, double amountInUSD) throws Exception {
		PropertiesReader reader = PropertiesReader.getInstance();
		String fee = null;
		if ("Individual".equalsIgnoreCase(clientType)) {
			if (amountInUSD >= 0 && amountInUSD <= 8000) {
				fee = reader.getProperty("INDIVIDUAL_0_8000");
			} else if (amountInUSD > 8000 && amountInUSD <= 20000) {
				fee = reader.getProperty("INDIVIDUAL_8000_20000");
			} else if (amountInUSD > 20000 && amountInUSD <= 35000) {
				fee = reader.getProperty("INDIVIDUAL_20000_35000");
			} else if (amountInUSD > 35000) {
				fee = reader.getProperty("INDIVIDUAL_ABOVE_35000");
			}
		} else if ("Corporate".equalsIgnoreCase(clientType)) {
			if (amountInUSD >= 0 && amountInUSD <= 1000000) {
				fee = reader.getProperty("CORPORATE_0_1");
			} else if (amountInUSD > 1000000 && amountInUSD <= 3000000) {
				fee = reader.getProperty("CORPORATE_1_3");
			} else if (amountInUSD > 3000000) {
				fee = reader.getProperty("CORPORATE_ABOVE_3");
			}
		}

		return Long.parseLong(fee);

	}
}
