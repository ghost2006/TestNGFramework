package com.syntax.testcases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.syntax.pages.AddEmployeePage;
import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddEmployeeTest extends BaseClass{

	@Test (dataProvider="Employee Data", groups="regression")     //(dataProvider="employee details")
	public void addEmployee(String fName, String mName, String lName, String location) {
		LoginPage login=new LoginPage(); //creating an obj of each page
		HomePage home=new HomePage();
		AddEmployeePage addEmp=new AddEmployeePage();
		
		//login to add OrangeHRM
		login.login(ConfigsReader.getProperty("username"), ConfigsReader.getProperty("password"));
		
		//navigate to add Employee
		CommonMethods.click(home.pim);
		CommonMethods.click(home.addEmp);
		
		//enter employee details
		CommonMethods.sendText(addEmp.firstName, fName);
		CommonMethods.sendText(addEmp.midName, mName);
		CommonMethods.sendText(addEmp.lastName, lName);
		CommonMethods.click(addEmp.location);
	    CommonMethods.selectList(addEmp.locationList, location);
		
		CommonMethods.click(addEmp.saveBtn);
		
		//verify employee is added
		CommonMethods.waitForElementBeClickable(addEmp.empCheck, 20);
		String verifText=addEmp.empCheck.getText();
		Assert.assertEquals(verifText, fName+ " "+lName);
	}	
	
	@DataProvider(name="Employee Data") //using Excel file
	public Object[][] getEmpData() {
		ExcelUtility obj =new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "EmployeeDetails");
		
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
		Object [][]data=new Object[rows-1][cols];//skipping 11th row, creating only 10 objects of data Object[10][4]
		for (int i=1; i<rows; i++) {
			for (int j=0; j<cols; j++) {
				String value=obj.getCellData(i, j);
				data[i-1][j]=value; //index has to be always length-1
			}
		}
		return data;
	}
	
		@DataProvider(name="employee details")
		public Object [][] getData(){
			Object [][] data=new Object[3][4];
			//1 set
			data [0][0]="John";
			data [0][1]="Snow";
			data [0][2]="White";
			data [0][3]="HQ";
			
			data [1][0]="Jane";
			data [1][1]="Rain";
			data [1][2]="Yellow";
			data [1][3]="North Office";
			
			data [2][0]="Arya";
			data [2][1]="Sunny";
			data [2][2]="Blue";
			data [2][3]="West Office";
			return data;
		}
		
	
}
