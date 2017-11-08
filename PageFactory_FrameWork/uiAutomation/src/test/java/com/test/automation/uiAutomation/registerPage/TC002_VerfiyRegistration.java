package com.test.automation.uiAutomation.registerPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.RegisterPage;

public class TC002_VerfiyRegistration extends TestBase {

	RegisterPage registerPage;
	HomePage homePage;
	String emailAddress = "Jagjeet_"+System.currentTimeMillis()+"@gmail.com";
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test
	public void verfiyRegistration() {
		log("----------------Starting Test TC002_VerfiyRegistration----------------");
		homePage = new HomePage(driver);
		homePage.navigateToLoginPage();
		registerPage = new RegisterPage(driver);
		registerPage.registerToApplication(emailAddress, "Jagjeet", "Singh", "Password1", "Add Fir Name","Add Last Name", "Address Line 1", "City", "Alabama", "12345", "United States", "1234567890", "Alias");
		Assert.assertEquals(true, registerPage.getRegistrationSuccess());
		Assert.assertEquals(registerPage.getRegistrationSuccessMessageText(), "Jagjeet Singh");
		log("----------------Completed Test TC002_VerfiyRegistration----------------");
	}
}
