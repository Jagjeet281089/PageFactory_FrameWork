package com.test.automation.uiAutomation.productListigPage;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.ProductListigPage;

public class TC001_VerifyProductLoads extends TestBase{
	
	ProductListigPage productListigPage;
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test
	public void verifyProductLoads() throws InterruptedException{
		log("----------------Statring Test TC001_verifyProductLoads----------------");
		productListigPage = new ProductListigPage(driver);
		productListigPage.navigateToItemType("Women", "Tops", "T-shirts");
		log("----------------Finished Test TC001_verifyProductLoads----------------");
	}
	
}
