package com.syntax.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelDemo {
	
	@Test
	public void readExcel() throws IOException {
		String xlPath="src/test/resources/testdata/OrangeHrmData.xlsx"; //specifying xl file path
		FileInputStream fis=new FileInputStream(xlPath);// create file input stream object and load file
		
		XSSFWorkbook workbook=new XSSFWorkbook(fis); //XSSFWorkbook class // create object for workbook and load file
		
		XSSFSheet sheet=workbook.getSheet("EmployeeDetails"); // get the sheet which you want to modify or create
		
	//	XSSFRow row = sheet.getRow(0);  //create object for row
	//	XSSFCell cell = row.getCell(0); //create object for cell
		
		//accessing 5 row and 1 column
		String value=sheet.getRow(4).getCell(0).toString(); //based on 0-index, here we're accessing specified data
		System.out.println(value);
		//accessing first row 4th column
		System.out.println(sheet.getRow(0).getCell(3).toString());
		
		//how to find number of rows
		int rowNum =sheet.getPhysicalNumberOfRows();// method returns # of rows 
		
		//how to find # of cell
		int colNum=	sheet.getRow(0).getLastCellNum();
		
		System.out.println(rowNum);
		System.out.println(colNum);
		
		//retrieve all data
		for (int i=0; i<rowNum; i++) {
			for(int j=0; j<colNum; j++) {
				String cellValue=sheet.getRow(i).getCell(j).toString();
				System.out.print(cellValue+" ");
			}
			System.out.println();
		}
		workbook.close();
		fis.close(); //always have to close the stream!!!!
	}
}
