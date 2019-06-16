package com.syntax.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;

public class LoginPage extends BaseClass{
	
	//2d way using PageFactory class of selenium 
	
	    // Locating WebElemennts using @FindBy annotation of FindBy interface
		@FindBy(id="txtUsername") //Specifying which locator we're looking for
		public WebElement userName;
		
		@FindBy(name="txtPassword") //can use all locators
		public WebElement password;
		
		@FindBy(id="btnLogin")
		public WebElement loginBtn;
		
		@FindBy(css="img[src*='logo.png']")
		public WebElement logo;
		
		@FindBy(xpath="//div[@class='toast-message']")
		public WebElement invalidLog;
		
		//initialize all our Variables
		public LoginPage(){ //Once we call static initElements() method, all elements of the current page will get initialized at once
			PageFactory.initElements(driver, this); //this - means our page
		}
		
		public void login(String uname, String pwd){ //use it for adding employee
			CommonMethods.sendText(userName, uname);
			CommonMethods.sendText(password, pwd);
			CommonMethods.click(loginBtn);
		}
}