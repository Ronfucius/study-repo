package com.ron;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	// Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";

	// Student attributes index
	private static final int PK = 0;
	private static final int DEBIT_AMOUNT = 1;
	private static final int CREDIT_AMOUNT = 5;
	private static final int HEAD_OFFICE_BRANCH_NAME = 9;
	private static final int ACCOUNT_ITEM_NAME = 10;

	public static void readCsv(String fileName) {

		BufferedReader fileReader = null;

		try {

			List<Account>accounts = new ArrayList<Account>();
			String line = "";
			
			fileReader = new BufferedReader (new FileReader(fileName));

			fileReader.readLine();

			while ((line = fileReader.readLine()) != null) {

				String[] tokens = line.split(COMMA_DELIMITER);
				if (tokens.length > 0) {
					
					Account account = new Account(Long.parseLong(tokens[PK]), tokens[DEBIT_AMOUNT],
							tokens[CREDIT_AMOUNT], tokens[HEAD_OFFICE_BRANCH_NAME], tokens[ACCOUNT_ITEM_NAME]);
					
					accounts.add(account);
				}
			}
								

			for (Account account : accounts) {
				System.out.println(account.toString());
			}	
		} 
		
		catch (Exception e) {
			System.out.println("Csv Reader Error");
			e.printStackTrace();
		} finally {
			try {
				fileReader.close();
			} catch (IOException e) {
				System.out.println("Error when closing fileReader");
				e.printStackTrace();
			}
		}

	}

}
