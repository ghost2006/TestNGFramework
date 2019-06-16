package com.syntax.practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelWriteDemo {

	@Test
	public void writeExcel() throws Exception {
	String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx";
	
	FileInputStream fis=new FileInputStream(xlPath);
	//open workbook & sheet
	XSSFWorkbook workbook=new XSSFWorkbook(fis);
	XSSFSheet sheet=workbook.getSheet("EmployeeDetails");
	
	//write some values
	               //create cell--> set the value 
	sheet.getRow(0).createCell(4).setCellValue("Result");
	sheet.getRow(1).createCell(4).setCellValue("Pass");
	              // changing the value in a specific cell
	sheet.getRow(1).getCell(4).setCellValue("Fail");
	//creating a Row
	sheet.createRow(11).createCell(0).setCellValue("Mehmet");
	//write to excel
	FileOutputStream fos=new FileOutputStream(xlPath);
	workbook.write(fos);
	
	//close file and streams
	fos.close();
	workbook.close();
	fis.close();
	
}
}