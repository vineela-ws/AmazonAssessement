package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonGpPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.util.TestUtil;

public class AmazonGpPageTest extends TestBase {
	SignUpPage signUpPage;
	AmazonGpPage amazonGpPage;
	TestUtil testUtil;

	Logger log = Logger.getLogger(AmazonGpPageTest.class);

	public AmazonGpPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		testUtil = new TestUtil();
		amazonGpPage=signUpPage.performActionsOnSigupPage();
	}
		
	@Test(priority=1)
	public void verifyAmazonGpPageTitleTest() throws InterruptedException{
		Thread.sleep(8000);
		String amazonGpPageTitle = amazonGpPage.validateAmazonGpPageTitle();
		Assert.assertEquals(amazonGpPageTitle, "Buy the latest LED TVs, 4K TVs and Android TVs online at Best Prices in India-Amazon.in | Shop by size, price, features and more","AmazonGp page title not matched");
		log.info("amazonGpPageTitle: "+amazonGpPageTitle);
	}
	
	@Test(priority=2)
	public void clickSamsungCheckbox() {
		amazonGpPage.clickSamsungCheckbox();
		log.info("Samsung Brand are displayed");
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
