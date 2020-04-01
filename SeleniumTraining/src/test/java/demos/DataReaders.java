package demos;

import java.util.List;

import util.CSV;
import util.Excel;

public class DataReaders {

	public static void main(String[] args) {
	//	readCSV();
		readXLS();
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
	
	public static void readXLS() {
		String filename = "D:\\dev\\udemy\\selenium\\SDET-selenium\\SeleniumTraining\\src\\resources\\original.xls";
		String[][] data = Excel.get(filename);
		
		for(String[] record : data) {
			System.out.println("\nNEW RECORD");
			for(String cell : record) {
				System.out.println(cell);
			}
		}
	}
	
}
