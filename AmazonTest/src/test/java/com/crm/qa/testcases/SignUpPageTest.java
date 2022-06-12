
//"<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd" >"
package com.crm.qa.testcases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonGpPage;
import com.crm.qa.pages.SignUpPage;

public class SignUpPageTest extends TestBase{
	SignUpPage signUpPage;
	AmazonGpPage amazonGpPage;
	
	Logger log = Logger.getLogger(SignUpPageTest.class);

		
	public SignUpPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		signUpPage = new SignUpPage();	
	}
	
	@Test(priority=1)
	public void signUpPageTitleTest(){
		String title = signUpPage.validateSignUpPagePageTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		log.info("signUpTitle: "+title);
	}
	
	@Test(priority=2)
	public void performActionsOnSigupPage() {
		signUpPage.performActionsOnSigupPage();	
		log.info("Actions are performed on Signup pages");
	}
		  	 	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
