package com.test.automation.uiAutomation.customerSide;




import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.AutomaticBookingPage;

public class TC001_CheckifBookingSuccessful extends TestBase {
	AutomaticBookingPage automaticBookingPage;
	
	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test
	public void testName() {
		automaticBookingPage  = new AutomaticBookingPage(driver);
		
		log("----------------Starting Test TC001_CheckifBookingSuccessful----------------");
		
		getURL("https://cfapp.staticso2.com/1231231123");
		automaticBookingPage.submitTimeZonePopup();
		automaticBookingPage.selectFirstAvailableBookingTime();
		
		
		log("----------------Completed Test TC001_CheckifBookingSuccessful----------------");
	
	}

	@AfterClass
	public void endTest() {
		end();
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}

