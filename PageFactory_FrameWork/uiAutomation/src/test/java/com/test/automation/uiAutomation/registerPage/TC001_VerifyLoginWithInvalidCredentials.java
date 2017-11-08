package com.test.automation.uiAutomation.registerPage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.RegisterPage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase{

	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());

	HomePage homePage;
	RegisterPage registerPage;
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	@BeforeClass
	public void setup() throws IOException{
		init();
	}
	
	@Test
	public void verifyLoginWithInvalidCredentials() throws InterruptedException{
		log("----------------Statring Test TC001_VerifyLoginWithInvalidCredentials----------------");
		homePage = new HomePage(driver);
		homePage.navigateToLoginPage();
		registerPage = new RegisterPage(driver);
		registerPage.loginToApplication("test@test.com", "qaz123wsx");
		Thread.sleep(5000);
		Assert.assertEquals(registerPage.getauthenticationFailedMessageText(), "Authentication failed.");
		log("----------------Finished Test TC001_VerifyLoginWithInvalidCredentials----------------");
	}
}
