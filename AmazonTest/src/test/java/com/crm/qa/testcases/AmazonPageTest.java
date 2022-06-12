package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonGpPage;
import com.crm.qa.pages.AmazonPage;
import com.crm.qa.pages.SignUpPage;
import com.crm.qa.util.TestUtil;

public class AmazonPageTest extends TestBase {
	SignUpPage signUpPage;
	AmazonGpPage amazonGpPage;
	AmazonPage amazonPage;
	TestUtil testUtil;
	Logger log = Logger.getLogger(AmazonPageTest.class);

	public AmazonPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		signUpPage = new SignUpPage();
		testUtil = new TestUtil();
		amazonGpPage=signUpPage.performActionsOnSigupPage();
		amazonPage =amazonGpPage.clickSamsungCheckbox();
	}
	
	@Test(priority=1)
	public void verifyAmazonPageTitleTest() throws InterruptedException{
		String amazonPageTitle = amazonPage.verifyAmazonPageTitle();
		Assert.assertEquals(amazonPageTitle, "Amazon.in");
		log.info("amazonPageTitle: "+amazonPageTitle);

	}
	
	@Test(priority=2)
	public void performActionsOnAmazonPage() throws InterruptedException {
		amazonPage.performActionsOnAmazonPage(prop.getProperty("sortDropdownValue"));
		log.info("Actions are performed on Amazon pages");
	}
		
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
