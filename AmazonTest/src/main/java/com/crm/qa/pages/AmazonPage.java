package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.Iterator; 
import java.util.Set;

import com.crm.qa.base.TestBase;

public class AmazonPage extends TestBase {
	
	@FindBy(xpath = "//select[@id='s-result-sort-select']")
	WebElement sortDropdown;
	
	@FindBy(xpath = "//div[@cel_widget_id='MAIN-SEARCH_RESULTS-2']")
	WebElement secondHighestProduct;
	
	@FindBy(xpath = "//*[contains(text(),' About this item ')]")
	WebElement aboutThisItem;
	
	@FindBy(xpath = "//*[@class='a-unordered-list a-vertical a-spacing-mini']")
	WebElement aboutThisItemDescription;
	

	// Initializing the Page Objects:
	public AmazonPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String verifyAmazonPageTitle(){
		return driver.getTitle();
	}
	
	public void performActionsOnAmazonPage(String sortDropdownValue) throws InterruptedException {
		selectValueFromFeatureDropdown(sortDropdownValue);
	    clickSecondHighestProduct();
		verifyAboutThisItem();
		printAboutThisItemDescription();
	}
	
	private void selectValueFromFeatureDropdown(String sortDropdownValue) throws InterruptedException {
		Thread.sleep(5000);
		WebElement ele =sortDropdown;
		Select select = new Select(ele);
		select.selectByVisibleText(sortDropdownValue);
	}
		
	private void clickSecondHighestProduct() throws InterruptedException {	
		Thread.sleep(15000);
		secondHighestProduct.click();
        //Window Handling and switching to child window 
		String parent=driver.getWindowHandle();
		Set<String>s=driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1= s.iterator();

		while(I1.hasNext())
		{
		String child_window=I1.next();
		if(!parent.equals(child_window)){
		driver.switchTo().window(child_window);		
		}		
	 }		
  }
	
	private void verifyAboutThisItem(){
		  WebElement ele = aboutThisItem;
		  String aboutThisItem = ele.getText();
		  Assert.assertEquals(aboutThisItem, "About this item");	 
	}	
	
	private void printAboutThisItemDescription(){
		  WebElement ele = aboutThisItemDescription;
		  String aboutThisItemDescription = ele.getText();
		  System.out.println("aboutThisItemDescription" +aboutThisItemDescription);
	}	
}
