package com.test.automation.uiAutomation.uiActions;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.test.automation.uiAutomation.uiActions.ProductDetailsPage;

public class AutomaticBookingPage {

	@FindBy(xpath="//button[@class= 'btn btn-default btn-facebook']")
	WebElement facebookButton;
	
	@FindBy (id="tzConfirmBtn")
	WebElement timeZoneContinueButton;

	@FindBy (id ="monthHeading")
	WebElement currentMonthName;

	@FindBy(xpath="//button[@type = 'button' and @class = 'next active']/span[@class='ng-binding leftAngletext']")
	WebElement nextMonthText;
	
	
	public static final Logger log = Logger.getLogger(ProductDetailsPage.class.getName());
	WebDriver driver;

	public AutomaticBookingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is a construct that will initialize all the webelements defined above under page factory.
	}
	
	public void submitTimeZonePopup(){
		try {
			timeZoneContinueButton.click();
			log("Time Zone Pup Submitted.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log("Unable to See Time Zone Pup.");
		}
	}
	
	
	public boolean checkIfBoookingDateAvailable(){
		
		List<WebElement> allAvailableDates = driver.findElements(By.xpath("//button[@class= 'day ng-scope boldDay']"));
        boolean status = false;
        if (allAvailableDates.size()==0){
        	status = false;
        	log("No dates available for booking in the Month "+ currentMonthName);
        }
        else{
        	status = true;
        	log("Dates available for booking in the Month "+ currentMonthName);
        }
		return status;		
	}
	
	
	public void selectNextMonth(){		
		nextMonthText.click();
		log("Clicked on next button to reach Month: "+nextMonthText.getText().toString());
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log("Clicked on next button to reach Month: "+nextMonthText.getText().toString());
			
	}
	

	
	public void selectFirstAvailableBookingTime(){
		
		checkIfBoookingDateAvailable();
		while(checkIfBoookingDateAvailable() == false){
			selectNextMonth();
			checkIfBoookingDateAvailable();
		}
		
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	
	
	
	

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}