package com.syntax.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReview {
	
	@Test
	public void readExcel() throws IOException {
		String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
		FileInputStream fis=new FileInputStream(xlPath);
		//open workbook
		XSSFWorkbook workbook= new XSSFWorkbook(fis);
		//open specified sheet
		XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
		// access value of specific cell (row --> column)
		String value=sheet.getRow(6).getCell(0).toString();
		//get # of rows and columns
		int rows=sheet.getPhysicalNumberOfRows();
		int cols=sheet.getRow(0).getLastCellNum();
		System.out.println(" # of rows and columns "+ rows+" "+cols);
		//get value from each cell 1 by 1
		for (int i=1; i<rows; i++) { // we skipped header, so starting print from 1 index
			for (int j=0; j<cols; j++) {
			String cellValue=sheet.getRow(i).getCell(j).toString();
			System.out.println(cellValue);
			}
		}
		//close workbook and stream
		workbook.close();
		fis.close();
}
}