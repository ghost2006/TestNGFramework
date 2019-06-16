package com.syntax.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.syntax.pages.HomePage;
import com.syntax.pages.LoginPage;
import com.syntax.pages.LoginPageWithoutPageFactory;
import com.syntax.utils.BaseClass;
import com.syntax.utils.CommonMethods;
import com.syntax.utils.ConfigsReader;

public class LoginPageTest extends BaseClass{
	
	@Test (groups="smoke")
	public void loginToOrangeHRM() {
		//test= report.createTest("Positive login"); //creating one test in our report, will return object of ExtentTest type 
		LoginPageWithoutPageFactory login=new LoginPageWithoutPageFactory();
		test.info("Logging in with valid credentials");
		CommonMethods.sendText(login.username, "Admin");
		CommonMethods.sendText(login.password, "AQ5sx1X@nM");
		CommonMethods.click(login.btnLogin);
		test.info("Verifying dashboard text is displayed");
		HomePage home=new HomePage(); 
		boolean isDisplayed = home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}
	
	@Test(groups="smoke")
	public void doLogin() {
		test.info("Logging in with valid credentials");
		LoginPage login=new LoginPage();//creating an obj of the LoginPage to access our userName, pass instances
		CommonMethods.sendText(login.userName, ConfigsReader.getProperty("username"));
		CommonMethods.sendText(login.password, ConfigsReader.getProperty("password"));
		CommonMethods.click(login.loginBtn);
		test.info("Verifying dashboard text is displayed");
		HomePage home=new HomePage(); //creating an obj of the HomePage to verif login
		boolean isDisplayed = home.dashboardText.isDisplayed();
		Assert.assertTrue(isDisplayed);// or Assert.assertEquals(isDisplayed, true); 
	}
	/**
	 * verify user is unable to login with wrong credentials
	 */
	@Test (groups="regression")
	public void negativeLogin()  {
	LoginPage login=new LoginPage();//creating an obj of the LoginPage to access our userName, pass instances
	login.login("admins", "test");
	
	String errorText=login.invalidLog.getText();
	test.info("Verifying error message "+errorText);
	Assert.assertTrue(login.invalidLog.isDisplayed());
//	OR String errorText=login.invalidLog.getText();
//	Assert.assert.equals(errorText, "Invalid Credentials");
	}
	

}
