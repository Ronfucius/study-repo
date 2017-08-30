package com.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CsvWriteReadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		String timeStamp = new SimpleDateFormat("yyyy_MM_dd_HH_mm").format(new Date());
		
		String fileName = System.getProperty("user.dir") + "/" + timeStamp + "_student.csv";
		
		System.out.println("Write CSV file:");
		CsvFileWriter.writeCsvFile(fileName);
		
		System.out.println("\nRead CSV file:");
		CsvFileReader.readCsvFile(fileName);

	}

}
