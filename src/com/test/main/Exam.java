package com.test.main;

import java.util.ArrayList;
import java.util.List;

import com.test.jpmorgan.bean.Rates;
import com.test.jpmorgan.bean.Transaction;
import com.test.jpmorgan.bean.TransactionResult;
import com.test.jpmorgan.util.ProcessTranscation;
import com.test.jpmorgan.util.ReadCsv;
import com.test.jpmorgan.util.WriteCsv;

public class Exam {

	public static void main(String[] args) throws Exception{
		ReadCsv readCsv = new ReadCsv();
		List<Rates> rates = readCsv.getRates();
		List<Transaction> transactions = readCsv.getTransactionObjects();

		ProcessTranscation processTranscation = new ProcessTranscation();

		List<TransactionResult> transactionResults = new ArrayList<TransactionResult>();
		for (Transaction transaction : transactions) {
			TransactionResult transactionResult = processTranscation.process(
					transaction, rates);
			transactionResults.add(transactionResult);
		}
		
		WriteCsv writeCsv = new WriteCsv();
		writeCsv.writeCsvFile(transactionResults);
	}

}
