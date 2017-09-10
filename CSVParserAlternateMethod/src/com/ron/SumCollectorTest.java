package com.ron;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

public class SumCollectorTest {

	public static void main(String[] args) {

		String csvFile = "/home/ron/eclipse-workspace/CSVParser/Sum_Input.csv";
		BufferedReader br = null;
		String line = "";
		String csvSplitBy = ",";

		String timeLog = new SimpleDateFormat("YYYYMMdHmmss").format(Calendar.getInstance().getTime());
		File FileWrite = new File("/home/ron/eclipse-workspace/CSVParser/Sum_Output_" + timeLog + ".csv");

		try {

			PrintWriter pw = new PrintWriter(FileWrite);
			br = new BufferedReader(new FileReader(csvFile));

			while ((line = br.readLine()) != null) {

				String[] requestedColumns = line.split(csvSplitBy);
				String fileToBeWritten = (requestedColumns[0] + "," + requestedColumns[3] + "," + requestedColumns[4]
						+ "," + requestedColumns[6]);

				System.out.println("Requested First Column: " + requestedColumns[0].toString());
				System.out.println("Requested Fourth Column: " + requestedColumns[3].toString());
				System.out.println("Requested Fifth Column: " + requestedColumns[4].toString());
				System.out.println("Requested Seventh Column: " + requestedColumns[6].toString());

				// These convert CSV values to Strings, then Convert to an Integer

				String RequestedColumnOneString = requestedColumns[0].toString();
				int RequestedColumnOneInt = Integer.parseInt(RequestedColumnOneString);

				// These convert CSV values to Strings, then Convert to an Integer

				String RequestedColumnFourString = requestedColumns[3].toString();
				int RequestedColumnFourInt = Integer.parseInt(RequestedColumnFourString);

				// These convert CSV values to Strings, then Convert to an Integer

				String RequestedColumnFiveString = requestedColumns[4].toString();
				int RequestedColumnFiveInt = Integer.parseInt(RequestedColumnFiveString);

				// These convert CSV values to Strings, then Convert to an Integer

				String RequestedColumnSevenString = requestedColumns[6].toString();
				int RequestedColumnSevenInt = Integer.parseInt(RequestedColumnSevenString);

				// This takes the recently converted Integers and adds them to a List

				List<Integer> list = Arrays.asList(RequestedColumnOneInt, RequestedColumnFourInt,
						RequestedColumnFiveInt, RequestedColumnSevenInt);

				// This takes those list values and adds them up

				int result = list.stream().collect(Collectors.summingInt(i -> i));
				String SumToCSV = Integer.toString(result);

				// This prints the added value
				System.out.println("The sum of Columns 0,3,4, and 6: " + result);

				// Writes selected files from Input Data
				pw.println(fileToBeWritten);

				// Writes value summary data on new Line
				pw.println(SumToCSV);
			}
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
