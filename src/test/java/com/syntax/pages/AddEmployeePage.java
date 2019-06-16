package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;

public class AddEmployeePage extends BaseClass{
	@FindBy(xpath="//input[@id='firstName']")
	public WebElement firstName; //instance variable
	
	@FindBy(xpath="//input[@id='lastName']")
	public WebElement lastName;
	
	@FindBy(xpath="//input[@id='middleName']")
	public WebElement midName;
	
	@FindBy(xpath="//input[@id='employeeId']")
	public WebElement employeeId;
	
	@FindBy(xpath="//a[@id='systemUserSaveBtn']")
	public WebElement saveBtn;
	
	@FindBy(xpath="//div[@id='location_inputfileddiv']//input")
	public WebElement location;
	
	@FindBy(xpath="//div[@id='location_inputfileddiv']//ul")
    public WebElement locationList;
	
	@FindBy(xpath="//span[@id='pim.navbar.employeeName']")
	public WebElement empCheck;
	
	public AddEmployeePage(){ //initializing our instances
		PageFactory.initElements(driver, this);
	}
}
