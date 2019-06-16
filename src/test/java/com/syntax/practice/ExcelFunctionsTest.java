package com.syntax.practice;

import org.testng.annotations.Test;

import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class ExcelFunctionsTest {

	@Test
	public void excelTest() {

		ExcelUtility obj = new ExcelUtility();// to access our methods we have to create an object, cause our methods are not static
												
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");

		// retrieve all values from Excel and store it into data provider (2D object array)
		int row = obj.getRowNum();
		int cell = obj.getColNum(0);
		Object[][] data = new Object[row][cell];
		//loop through each row & column
		for (int i = 1; i < row; i++) { //started from 2 row (skipped the header)
			for (int j = 0; j < cell; j++) {
				// retrieve values from excel
				String value = obj.getCellData(i, j);
				data[i][j] = value; // storing values retrieved from excel to our dataProvider array
			}
		}
		System.out.println(data.length);
	}
}
