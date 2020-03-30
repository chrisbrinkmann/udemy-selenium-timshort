package demos;

import java.util.List;

import util.CSV;

public class DataReaders {

	public static void main(String[] args) {
		readCSV();
	}

	public static void readCSV() {
		String filename = "D:\\dev\\udemy\\selenium\\SDET-selenium\\SeleniumTraining\\src\\resources\\original.csv";
		List <String[]> records = CSV.get(filename);
		
		for(String[] record : records) {
			for (String field : record) {
				System.out.print(field);
			}
			System.out.println();
		}
	}
	
}
