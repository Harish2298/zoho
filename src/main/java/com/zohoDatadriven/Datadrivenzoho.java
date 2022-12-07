package com.zohoDatadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datadrivenzoho {
	static String value;

	public static String allData(String sheet,int rowNo, int cellNo) throws IOException {
		File t = new File("/Users/r.harish/eclipse-workspace/DataDriven/Excel/SubjectMark.xlsx");
		FileInputStream F = new FileInputStream(t);
		Workbook w = new XSSFWorkbook(F); // UpCasting
		Sheet s = w.getSheet(sheet);
		Row r = s.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		CellType cell = c.getCellType();

		if (cell.equals(CellType.STRING)) {
			value = c.getStringCellValue();

		} else if (cell.equals(CellType.NUMERIC)) {
			double numeric = c.getNumericCellValue();
		    int p = (int) numeric; // narrowing casting
          value=String.valueOf(p);
        
		}
		return value;

	}
	public static void main(String[] args) throws IOException {
		allData(value, 0, 0);
	}
	
	
	
	
	

}
