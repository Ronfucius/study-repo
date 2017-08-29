package com.ron;

public class CsvReadTest {

	public static void main(String[] args) {
		
		String fileName = System.getProperty("Users.Ronfucius.Desktop") + "/journal.csv";
		
		System.out.println("Reading CSV File");
		CsvReader.readCsv(fileName);

	}

}
