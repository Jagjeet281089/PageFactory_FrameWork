package com.test.automation.uiAutomation.registerPage;

import java.io.IOException;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.HomePage;
import com.test.automation.uiAutomation.uiActions.RegisterPage;

public class TC003_VerifyLoginWithDifferentCredentials extends TestBase {
	RegisterPage registerPage;
	HomePage homePage;
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData(){
		String LoginData[][]=getData("TestData.xlsx", "loginTest");
		return LoginData;
	}
	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test(dataProvider= "LoginData")
	public void verifyLoginWithDifferentCredentials(String emailAddress, String password, String runMode ) {
		registerPage = new RegisterPage(driver);
		homePage = new HomePage(driver);
		
		log("----------------Starting Test TC003_VerifyLoginWithDifferentCredentials----------------");
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("This data is marked as N. Hence skipping");
		}
		else{
			homePage.navigateToLoginPage();
			registerPage.loginToApplication(emailAddress, password);
			boolean status = registerPage.getLogoutLink();
			Assert.assertEquals(status,true);
			if(status == true){
				registerPage.logOut();
			}			
		}
		
		log("----------------Completed Test TC003_VerifyLoginWithDifferentCredentials----------------");
	}

}