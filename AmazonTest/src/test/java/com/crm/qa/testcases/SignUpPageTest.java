
package com.crm.qa.testcases;

import java.io.IOException;
import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.AmazonGpPage;
import com.crm.qa.pages.SignUpPage;
import com.gurock.testrail.APIException;
import com.qa.testrailmanager.TestRailManager;

public class SignUpPageTest extends TestBase{
	SignUpPage signUpPage;
	AmazonGpPage amazonGpPage;
	
	Logger log = Logger.getLogger(SignUpPageTest.class);
	protected String testcaseId;


		
	public SignUpPageTest(){
		super();
	}
	
	@BeforeTest
	public void setUp(){
		initialization();
		signUpPage = new SignUpPage();	
	}
	
	@Test(priority=1)
	public void signUpPageTitleTest(){
		testcaseId="1";
		String title = signUpPage.validateSignUpPagePageTitle();
		Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
		log.info("signUpTitle: "+title);
	}
	
	@Test(priority=2)
	public void performActionsOnSigupPage() {
		testcaseId="2";
		signUpPage.performActionsOnSigupPage();	
		log.info("Actions are performed on Signup pages");
	}
		  	 	
	@AfterTest
	public void tearDown(){
		driver.quit();
	}
	
	
	@AfterMethod
	public void addresultsToTestRail(ITestResult result) throws MalformedURLException, IOException, APIException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			TestRailManager.addResultsForTestcase(testcaseId, TestRailManager.TEST_CASE_PASS_STATUS,"");	
		} else if (result.getStatus()==ITestResult.FAILURE) {
			TestRailManager.addResultsForTestcase(testcaseId, TestRailManager.TEST_CASE_FAIL_STATUS,
					"Test got failed---" +result.getName()+ ": FAILED");	
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
