package com.dezlearn.lib;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelLib {
	
	public Object [][] Get_Excel_Data(String filename, String sheetname, int numberOfCols){
		
		File file = new File(filename);
		
		XSSFWorkbook wkbook;
		XSSFSheet sheet;
		Object [][] arr = new Object[0][0];
		
		try {
			FileInputStream excel = new FileInputStream(file);
			wkbook = new XSSFWorkbook(excel);
			sheet = wkbook.getSheet(sheetname);
			int start = sheet.getFirstRowNum();
			int end = sheet.getLastRowNum();
			arr = new Object[end-start+1][numberOfCols];
			for(int i = start; i <= end; i++) {
				for(int j = 0; j <= numberOfCols-1; j++) {
					arr[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				}
			}
			
		} catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		return arr;
	}
}
