package com.test.automation.uiAutomation.productDetailsPage;

import java.io.IOException;
import java.util.Iterator;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.test.automation.uiAutomation.testBase.TestBase;
import com.test.automation.uiAutomation.uiActions.ProductDetailsPage;

public class TC002_VerifyFacebookShareLink extends TestBase{

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
	public void verifyFacebookShareLink() throws InterruptedException{


		productDetailsPage= new ProductDetailsPage(driver);

		log("----------------Statring Test TC002_VerifyFacebookShareLink----------------");
		
		driver.navigate().to("http://automationpractice.com/index.php?id_product=1&controller=product");
		productDetailsPage.clickFacebookButton();
		
		Iterator<String> itr = getAllWindows();
		String mainWindow = itr.next();
		String facebookPopup =itr.next();
		driver.switchTo().window(facebookPopup);
		
		boolean status = productDetailsPage.checkFacebookPopUpHeader();
		Assert.assertEquals(true, status);
		driver.switchTo().window(mainWindow);
		
		log("----------------Finished Test TC002_VerifyFacebookShareLink----------------");
	}
}


/*In case there are lots of windows/popup opening 
and we don't know the number of windows that will be opening.
We can handle it by using a list.

	List<String> WindowIds = new ArrayList<String>();
	
	@Test
	public void navigateToDifferentPopups(){
		
		//This block will get all the window handle IDs to a list
		Iterator<String> itr = getAllWindows();
		While(itr.hasNext()){
			WindowIds.add(itr.next());
		}
		
		//Now navigating to different windows
		driver.switchTo().window(WindowIds.get(0)); // To Switch to default window
		driver.switchTo().window(WindowIds.get(4)); // To Switch to 5th window
	
	}

*/



