package com.test.automation.uiAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ProductListigPage {

	public static final Logger log = Logger.getLogger(ProductListigPage.class.getName());
	WebDriver driver;

	public ProductListigPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // This is a construct that will initialize all the webelements defined above under page factory.
	}
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	public void selectProductAs(String productTitle){
		WebElement product = driver.findElement(By.xpath("//h5[@itemprop= 'name']/a[contains(text(),'"+productTitle+"')]"));
		int x = product.getLocation().x;
		int y = product.getLocation().y;
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//Scrolling to position
		System.out.println(x+","+y);
		js.executeScript("scroll("+x+", "+y+")");
		product.click();
		log("Product Selected as:"+productTitle);
		
	}

	public void navigateToItemType(String mainCategory,String subCategory,String type){

		driver.findElement(By.xpath("//div[@id='block_top_menu']/ul[1]/li/a[contains(text(),'"+mainCategory+"')]")).click();
		log("Main category choosen as:"+mainCategory);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='categories_block_left']/div[1]/ul[1]/li/a[contains(text(),'"+subCategory+"')]/preceding-sibling::span[1]")));		
		WebElement subCat = driver.findElement(By.xpath("//div[@id='categories_block_left']/div[1]/ul[1]/li/a[contains(text(),'"+subCategory+"')]/preceding-sibling::span[1]"));
		subCat.click();
		log("Sub category choosen as:"+subCategory);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='categories_block_left']/div[1]/ul[1]/li/a[contains(text(),'"+subCategory+"')]/following-sibling::ul[@style='display: block;']/child::li/child::a[contains(text(),'"+type+"')]")));
		WebElement pType = driver.findElement(By.xpath("//div[@id='categories_block_left']/div[1]/ul[1]/li/a[contains(text(),'"+subCategory+"')]/following-sibling::ul[@style='display: block;']/child::li/child::a[contains(text(),'"+type+"')]"));
		pType.click();
		log("Product Type choosen as:"+type);
	}


}
