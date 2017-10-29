package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class RegisterPage {
	
	@FindBy(xpath="//*[@id='header']/div[2]/div/div/nav/div[1]/a")
	WebElement signIn;

	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmailAddress;

	@FindBy(xpath="//*[@id='passwd']")
	WebElement loginPassword;

	@FindBy(id="SubmitLogin")
	WebElement loginSubmitbutton;

	@FindBy(xpath="//*[@id='center_column']/div[1]/ol/li")
	WebElement authenticationFailedMessage;

	@FindBy(id="email_create")
	WebElement registerEmail;

	@FindBy(id="SubmitCreate")
	WebElement registerSubmitOne;

	@FindBy(id="customer_firstname")
	WebElement firstName;

	@FindBy(id="customer_lastname")
	WebElement lastName;

	@FindBy(id="passwd")
	WebElement password;

	@FindBy(id="firstname")
	WebElement addressFirstName;

	@FindBy(id="lastname")
	WebElement addressLastName;

	@FindBy(id="address1")
	WebElement addressLine1;

	@FindBy(id="city")
	WebElement city;

	@FindBy(id="id_state")
	WebElement state;

	@FindBy(id="postcode")
	WebElement postcode;

	@FindBy(id="id_country")
	WebElement country;

	@FindBy(id="phone_mobile")
	WebElement mobile;

	@FindBy(id="alias")
	WebElement alias;

	@FindBy(id="submitAccount")
	WebElement registerSubmitTwo;

	@FindBy(xpath = "//a[@title='View my customer account']/span")
	WebElement registrationSuccessMessage;

	@FindBy(xpath="//a[@class='logout' and @title='Log me out']")
	WebElement logOut;

	public static final Logger log = Logger.getLogger(RegisterPage.class.getName());
	WebDriver driver;


	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is a construct that will initialize all the webelements defined above.
	}
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	

	//Method performs login on the application with the given Email and password
	public void loginToApplication(String emailAddress, String password){
		log("Clicked on Signin link at Home page & the object is:"+signIn.toString());
		loginEmailAddress.clear();
		loginEmailAddress.sendKeys(emailAddress);
		log("Entered email address "+emailAddress+" and the object is:"+loginEmailAddress.toString());
		loginPassword.clear();
		loginPassword.sendKeys(password);
		log("Entered email address "+password+" and the object is:"+loginPassword.toString());
		loginSubmitbutton.click();
		log("Clicked on login Submit button & the object is:"+loginSubmitbutton.toString());
	}

	public String getauthenticationFailedMessageText(){
		log("Authentication Faiulre message text is: "+authenticationFailedMessage.getText());
		return authenticationFailedMessage.getText();
	}

	public void registerToApplication(String registerEmail, String firstName, String lastName, String password, String addressFirstName, String addressLastName, String addressLine1, String city, String state, String postcode, String country, String mobile, String alias){
		log("Clicked on Signin link at Home page & the object is:"+signIn.toString());
		this.registerEmail.sendKeys(registerEmail);
		log("Entered email address "+registerEmail+" and the object is:"+this.registerEmail.toString());		
		int x = registerSubmitOne.getLocation().x;
		int y = registerSubmitOne.getLocation().y;

		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Scrolling to position
		System.out.println(x+","+y);
		js.executeScript("scroll("+x+", "+y+")");
		registerSubmitOne.click();

		log("Clicked on Register1 Button at Home page & the object is:"+registerSubmitOne.toString());		
		this.firstName.clear();
		this.firstName.sendKeys(firstName);
		log("Entered First Name "+firstName+" and the object is:"+this.firstName.toString());
		this.lastName.sendKeys(lastName);
		log("Entered Last Name "+lastName+" and the object is:"+this.lastName.toString());
		this.password.clear();
		this.password.sendKeys(password);
		log("Entered Password "+password+" and the object is:"+this.password.toString());
		this.addressFirstName.clear();
		this.addressFirstName.sendKeys(addressFirstName);
		log("Entered Address First Name "+addressFirstName+" and the object is:"+this.addressFirstName.toString());
		this.addressLastName.clear();
		this.addressLastName.sendKeys(addressLastName);
		log("Entered Address Last Name "+addressLastName+" and the object is:"+this.addressLastName.toString());
		this.addressLine1.clear();
		this.addressLine1.sendKeys(addressLine1);
		log("Entered Address Line 1 "+addressLine1+" and the object is:"+this.addressLine1.toString());
		this.city.clear();
		this.city.sendKeys(city);
		log("Entered city  "+city+" and the object is:"+this.city.toString());
		Select stateDropdown = new Select(this.state); stateDropdown.selectByVisibleText(state);
		log("Selected State "+state+" and the object is:"+this.state.toString());
		this.postcode.clear();
		this.postcode.sendKeys(postcode);
		log("Entered postcode "+postcode+" and the object is:"+this.postcode.toString());
		Select countryDropdown = new Select(this.country);countryDropdown.selectByVisibleText(country);
		log("Selected Country "+country+" and the object is:"+this.country.toString());
		this.mobile.clear();
		this.mobile.sendKeys(mobile);
		log("Entered mobile "+mobile+" and the object is:"+this.mobile.toString());
		this.alias.clear();
		this.alias.sendKeys(alias);
		log("Entered alias "+alias+" and the object is:"+this.alias.toString());
		registerSubmitTwo.click();
		log("Clicked on Register2 Button at Home page & the object is:"+registerSubmitTwo.toString());
	}


	public String getRegistrationSuccessMessageText(){
		log("Registration success message text is:"+registrationSuccessMessage.getText());
		return registrationSuccessMessage.getText();
	}

	public boolean getRegistrationSuccess(){

		try {
			registrationSuccessMessage.isDisplayed();
			log("Registration success element found. Object is: "+registrationSuccessMessage.toString());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			log("Registration success element not found");
			return false;
		}
	}

	public boolean getLogoutLink(){
		try {
			logOut.isDisplayed();
			log("Logout element found. Object is: "+logOut.toString());
			return true;
		} catch (Exception e) {
			log("Logout Link element not found.");
			return false;
		}
	}

	public void logOut(){
		logOut.click();
		log("Clicked on Logout link at Home page & the object is:"+logOut.toString());
	}

}
