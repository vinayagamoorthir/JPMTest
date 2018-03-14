package com.test.jpmorgan.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.test.jpmorgan.bean.Rates;
import com.test.jpmorgan.bean.Transaction;

public class ReadCsv {

	public List<Transaction> getTransactionObjects() {
		List<Transaction> transactions = new ArrayList<Transaction>();
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(new FileReader("c:/" + "transactions.csv"));
			int lineNo = 0;
			while ((line = br.readLine()) != null) {
				lineNo++;
				if (lineNo == 1) {
					continue;
				}
				String[] rawTransaction = line.split(",");
				Transaction transaction = new Transaction();
				transaction.setBaseCurrency(rawTransaction[0]);
				transaction.setWantedCurrency(rawTransaction[1]);
				transaction.setAmountInBaseCurrency(rawTransaction[2]);
				transaction.setClientType(rawTransaction[3]);
				transaction.setTransactionTime(rawTransaction[4]);
				transactions.add(transaction);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return transactions;
	}

	public List<Rates> getRates() {
		List<Rates> rates = new ArrayList<Rates>();
		BufferedReader br = null;
		String line = "";

		try {

			br = new BufferedReader(new FileReader("c:/" + "rates.csv"));
			while ((line = br.readLine()) != null) {
				String[] rawRates = line.split(",");
				Rates rate = new Rates();
				rate.setBaseCurrency(rawRates[0]);
				rate.setWantedCurrency(rawRates[1]);
				rate.setRate(rawRates[2]);
				rate.setTransactionTime(rawRates[3]);
				rates.add(rate);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return rates;
	}

}