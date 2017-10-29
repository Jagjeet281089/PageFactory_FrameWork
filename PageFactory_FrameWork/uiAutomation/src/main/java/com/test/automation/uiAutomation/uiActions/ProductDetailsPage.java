package com.test.automation.uiAutomation.uiActions;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class ProductDetailsPage  {

	
	@FindBy(xpath="//button[@class= 'btn btn-default btn-facebook']")
	WebElement facebookButton;
	
	@FindBy (id="content")
	WebElement facebookPopupMainText;
	
	public static final Logger log = Logger.getLogger(ProductDetailsPage.class.getName());
	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is a construct that will initialize all the webelements defined above under page factory.
	}
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	public String getProductTitleText(){
		String productTitle = driver.findElement(By.xpath("//div[contains(@class,'pb-center-column')]/h1[@itemprop='name']")).getText();
		log("Returning Product Title:"+productTitle);
		return productTitle;
	}

	public void clickFacebookButton(){
		int x = facebookButton.getLocation().x;
		int y = facebookButton.getLocation().y;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Scrolling to position
		System.out.println(x+","+y);
		js.executeScript("scroll("+x+", "+y+")");
		facebookButton.click();
		log("Clicked on Facebook Share link and object is: "+facebookButton);
	}
	
	
	public boolean checkFacebookPopUpHeader(){
		log("Switched to Facebook popup.");
		try {
			facebookPopupMainText.isDisplayed();
			log("Facebook Popup header text is: "+facebookPopupMainText.getText());
			driver.close();
			return true;
		} catch (Exception e) {
			log("Facebook Popup header text did not displayed.");
			return false;
		}
		
	}

}
