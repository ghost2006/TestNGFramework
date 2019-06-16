package com.syntax.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.syntax.pages.HomePage;
import com.syntax.pages.LocationPage;
import com.syntax.pages.LoginPage;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;
import com.syntax.utils.Constants;
import com.syntax.utils.ExcelUtility;

public class AddLocationsTest extends BaseClass{

	@Test (dataProvider="Locations Data")
	public void addLocations(String name, String country, String city,String zip) {
		LoginPage login=new LoginPage(); //creating an obj of each page
		HomePage home=new HomePage();
		LocationPage location=new LocationPage();
		
		//login to add OrangeHRM
		login.login(ConfigsReader.getProperty("username"),ConfigsReader.getProperty("password"));
		
		//navigate to add Locations
		CommonMethods.click(home.admin);
		CommonMethods.click(home.organization);
		CommonMethods.click(home.locations);
		CommonMethods.click(location.addLocation);
		//enter locations
		CommonMethods.sendText(location.name, name);
		CommonMethods.click(location.country);
		CommonMethods.waitForElementBeClickable(location.contryList, 10);
		CommonMethods.selectList(location.contryList, country);
		CommonMethods.sendText(location.city, city);
		CommonMethods.sendText(location.zip, zip);
		CommonMethods.click(location.saveBtn);
		
		//VERIFICATION
		//waiting for "Successfully saved" to be present
		WebElement saved = driver.findElement(By.xpath("//div[@class='toast-message']"));
		CommonMethods.waitForElementBeVisible(saved, 3);
		Assert.assertTrue(saved.isDisplayed());
		
		WebElement locationCheck=driver.findElement(By.xpath("//table[@class='highlight bordered']/tbody/tr[1]/td[2]"));
		Assert.assertEquals(locationCheck.getText(), name);
		}
		
	@DataProvider(name="Locations Data")
	public Object [][] getLocData(){
		ExcelUtility obj=new ExcelUtility();
		obj.openExcel(Constants.XL_FILEPATH, "LocationsDetails");
		int rows=obj.getRowNum();
		int cols=obj.getColNum(0);
		
			Object [][] data=new Object[rows-1][cols];
			for (int i=1; i<rows; i++) {
				for (int j=0;j<cols;j++) {
				String value=obj.getCellData(i, j);
				data[i-1][j]=value;
				}
			}
			return data;
	}
	
	@DataProvider(name="add locations")
	@Test
	public Object[][] setData(){
		Object[][] data= new Object [5][4];
		data [0][0]="Smart Office";
		data [0][1]="Canada";
		data [0][2]="Toronto";
		data [0][3]="0909";
		
		data [1][0]="Central Office";
		data [1][1]="Russia";
		data [1][2]="Moscow";
		data [1][3]="0000";
		
		data [2][0]="South Office";
		data [2][1]="China";
		data [2][2]="Hong Kong";
		data [2][3]="3434";
		
		data [3][0]="New Office";
		data [3][1]="New Zeland";
		data [3][2]="Auckland";
		data [3][3]="1111";
		
		data [4][0]="First Office";
		data [4][1]="Spain";
		data [4][2]="Madrid";
		data [4][3]="7777";
		
		return data;
	}
	
}
