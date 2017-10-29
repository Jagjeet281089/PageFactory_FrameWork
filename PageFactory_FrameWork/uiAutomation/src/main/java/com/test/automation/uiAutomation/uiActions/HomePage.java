package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage {

	
	public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is a construct that will initialize all the webelements defined above.
	}
	
	public void navigateToLoginPage(){
		signIn.click();
		log("SignIn link clicked on the page nav Bar.");
	}
	
}
