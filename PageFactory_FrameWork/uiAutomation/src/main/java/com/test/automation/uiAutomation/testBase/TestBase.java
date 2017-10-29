package com.test.automation.uiAutomation.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.test.automation.uiAutomation.customListener.Listener;
import com.test.automation.uiAutomation.excelReader.Excel_Reader;


public class TestBase {
	
	
	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public static WebDriver driver;
	Excel_Reader excel_Reader;
	Listener lis;
	public Properties OR = new Properties();

	
//========//========//========Initializations FUNCTIONS//========//========//========//========//========//
	
	// Log initialization
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	//Initialize the test
	public void init() throws IOException{
		loadData();
		String log4jConfPath = "log4j.properties"; //Registering our Log4j file.
		PropertyConfigurator.configure(log4jConfPath); //Configuring our Log4j file.	
		selectBrowser(OR.getProperty("browser"));
		getURL(OR.getProperty("url"));
	}
	
	//Selects Browser
	public void selectBrowser(String browser){

		if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			log("Opening Browser"+ OR.getProperty("browser"));
			driver = new FirefoxDriver();	
		}
		else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			log("Opening Browser"+ OR.getProperty("browser"));
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
	}
	
	//Navigates to URL
	public void getURL(String url) {
		log("Opening URL"+ OR.getProperty("url"));
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	//Closes browser Instance
	public void end(){
		driver.quit();	
		log("Closing the Browser and driver instance!");
	}
	
	//Loads Property File
	public void loadData() throws IOException {
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/test/automation/uiAutomation/config/config.properties");
		FileInputStream f = new FileInputStream(file);
		OR.load(f);
	}
	
	
//========//========//========EXCEL FUNCTIONS//========//========//========//========//========//

	
	//get the Array of the data is the excel sheet.
	public String[][] getData(String excelName, String sheetName){
		String path = System.getProperty("user.dir")+"/src/main/java/com/test/automation/uiAutomation/data/"+excelName;
		excel_Reader = new Excel_Reader(path);
		String data[][]= excel_Reader.getDataFromSheet(sheetName, excelName);
		return data;
	}

	
//========//========//========UTILITY FUNCTIONS//========//========//========//========//========//
	
	//Take screenshot 
	public void getScreenShot(String name) {		
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/com/test/automation/uiAutomation/screenshot/";
			File destFile = new File((String) reportDirectory + name + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public Iterator<String> getAllWindows(){
		Set<String> windowsIds = driver.getWindowHandles();
		Iterator<String> itr = windowsIds.iterator();
		return itr;
	}
	
	public void waitForElement(WebDriver driver, int timeOutInSeconds, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
}
