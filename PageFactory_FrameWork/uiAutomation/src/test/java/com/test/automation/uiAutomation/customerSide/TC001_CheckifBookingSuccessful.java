package com.test.automation.uiAutomation.customerSide;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.AutomaticBookingPage;
import com.test.automation.uiAutomation.uiActions.RegisterPage;

public class TC001_CheckifBookingSuccessful extends TestBase {
	AutomaticBookingPage automaticBookingPage;
	
	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	@DataProvider(name="BookingData")
	public String[][] getBookingData(){
		String BookingData[][]=getData("TestData.xlsx", "Sheet3");
		//String BookingData[][]=getData("TestData.xlsx", "automaticBookingTestData");
		return BookingData;
	}
	
	
	@Test(dataProvider= "BookingData")
	public void testName(String year, String month, String date, String time, String runMode) {
		
		automaticBookingPage  = new AutomaticBookingPage(driver);
		
		log("----------------Starting Test TC001_CheckifBookingSuccessful----------------");
		
		if(runMode.equalsIgnoreCase("n")){
			throw new SkipException("This data is marked as N. Hence skipping");
		}
		else{
			getURL("https://cfapp.staticso2.com/PlusAccount2?name=Test%20Customer%20Name&email=jagjeetsinghenuke@gmail.com&skip=1");
			automaticBookingPage.makeAutomaticBookingAt(year,month,date,time);
		}
		
		log("----------------Completed Test TC001_CheckifBookingSuccessful----------------");
	
	}

	
	@AfterClass
	public void endTest() {
		//end();
	}
	

}

