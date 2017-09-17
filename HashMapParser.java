package com.ron2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class HashMapParser {

	public static void main(String[] args) {

		String csvFile = "/Users/Ronfucius/workspace/CSVParser/Sum_Input.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		String timeLog = new SimpleDateFormat("YYYYMMdHmmss").format(Calendar.getInstance().getTime());
		File FileWrite = new File("/Users/Ronfucius/workspace/CSVParser/Sum_Output_" + timeLog + ".csv");

		try {

			PrintWriter pw = new PrintWriter(FileWrite);
			br = new BufferedReader(new FileReader(csvFile));

			// reads to the end of the file (not just one row)

			while ((line = br.readLine()) != null) {

				String[] requestedColumns = line.split(cvsSplitBy);

				System.out.println("Requested First Column: " + requestedColumns[0]);
				System.out.println("Requested First Column: " + requestedColumns[3]);
				System.out.println("Requested First Column: " + requestedColumns[4]);
				System.out.println("Requested First Column: " + requestedColumns[6]);

				// ***

				// HashMap<String, String> map = new HashMap<String, String>();

				HashMap<String, String> map1 = new HashMap<String, String>();
				HashMap<String, String> map2 = new HashMap<String, String>();

				// Map<String, String> map TreeMap<String, String>();

				map1.put(requestedColumns[0], requestedColumns[3]);
				map2.put(requestedColumns[3], requestedColumns[0]);

				// Java 8 HashMap
				// map1.forEach((k,v) -> System.out.println("Key: " + k +
				// "Value: " + v) );

				map1.forEach((k1, v) -> System.out.println("Key 1: " + k1));
				map2.forEach((k2, v) -> System.out.println("Key 2: " + k2));

				// ****** Iterator Testing ******

				// For Loop

				for (Map.Entry<String, String> forLoopEntry : map1.entrySet()) {
					System.out.println("Key from For Loop: " + forLoopEntry.getKey());
				}

				// While Loop
				Iterator<Entry<String, String>> iterator = map1.entrySet().iterator();

				while (iterator.hasNext()) {
					Map.Entry<String, String> whileLoopEntry = (Map.Entry<String, String>) iterator.next();
					System.out.println("Key from Iterator: " + whileLoopEntry.getKey());
				}

				// ****** Iterator Testing ******

				// TRY INSERTING CONDITIONAL CODE HERE

				// ***

				// Summing Logic

				// These convert CSV value to a String, then convert to an
				// Integer

				String RequestedColumnFourString = requestedColumns[4];
				int requestedColumnFourInt = Integer.parseInt(RequestedColumnFourString);

				// These convert CSV value to a String, then convert to an
				// Integer

				String RequestedColumnSixString = requestedColumns[6];
				int requestedColumnSixInt = Integer.parseInt(RequestedColumnSixString);

				// This takes the recently converted Integers and adds them to a
				List<Integer> list = Arrays.asList(requestedColumnFourInt, requestedColumnSixInt);

				int result = list.stream().collect(Collectors.summingInt(i -> i));

				String SumToCSV = Integer.toString(result);

				// This prints the added value
				System.out.println("The sum of Columns 4 and 6: " + result);

				// Summing Logic

				// String fileToBeWritten = (requestedColumns[0] + "," +
				// requestedColumns[3] + "," + requestedColumns[4] + "," +
				// requestedColumns[6] + "," + SumToCSV);

				// ***
				// ArrayList<String> rows = new ArrayList<String>();
				// rows.add(requestedColumns[0]);

				// Collections.sort(rows);
				// pw.print(rows);

				// ***

				// Writes selected files from Input Data
				// pw.print(fileToBeWritten);

				// Prints HashMap along side Summed Totals

				map1.forEach((k, v) -> pw
						.println(k + "," + v + "," + requestedColumns[4] + "," + requestedColumns[6] + "," + SumToCSV));

				// Viewing Test

				map1.forEach((k, v) -> System.out
						.println(k + "," + v + "," + requestedColumns[4] + "," + requestedColumns[6] + "," + SumToCSV));

				// Writes value summary data on new line
				// pw.println(SumToCSV);

			}

			pw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
