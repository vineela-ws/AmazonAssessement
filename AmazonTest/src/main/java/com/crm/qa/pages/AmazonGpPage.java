package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class AmazonGpPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//span[text()='Samsung']")
	WebElement samsungCheckbox;
	
	
	//Initializing the Page Objects:
	public AmazonGpPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateAmazonGpPageTitle(){
		return driver.getTitle();
	}
	
	public AmazonPage clickSamsungCheckbox() {
		samsungCheckbox.click();
		return new AmazonPage();	
	}	
	
}
