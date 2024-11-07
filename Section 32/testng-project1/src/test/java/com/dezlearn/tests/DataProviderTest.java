package com.dezlearn.tests;

import org.testng.annotations.DataProvider;

import com.dezlearn.lib.ReadExcelLib;

public class DataProviderTest {
 

  @DataProvider
  public Object[][] dataProvider1() {
	  
	  ReadExcelLib excel = new ReadExcelLib();
	  String file = "/Users/mayurdeshmukh/eclipse-workspace24/testng-project1/TestData/TestData.xlsx";
	  return excel.Get_Excel_Data(file, "Sheet1", 3);
   
  }
  
  
}
