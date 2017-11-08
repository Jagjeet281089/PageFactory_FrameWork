package com.test.automation.uiAutomation.productDetailsPage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.ProductDetailsPage;
import com.test.automation.uiAutomation.uiActions.ProductListigPage;

public class TC001_VerifyProductTitle extends TestBase{

	ProductListigPage productListigPage;
	ProductDetailsPage productDetailsPage;
	
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	@BeforeClass
	public void setup() throws IOException {
		init();
	}

	@Test
	public void verifyProductTitle() throws InterruptedException{
		
		productListigPage = new ProductListigPage(driver);
		productDetailsPage= new ProductDetailsPage(driver);
		
		log("----------------Statring Test TC001_VerifyProductTitle----------------");
		productListigPage.navigateToItemType("Women", "Tops", "T-shirts");
		productListigPage.selectProductAs("Faded Short Sleeve T-shirts");
		Assert.assertEquals("Faded Short Sleeve T-shirts", productDetailsPage.getProductTitleText());
		log("----------------Finished Test TC001_VerifyProductTitle----------------");
	}
}
