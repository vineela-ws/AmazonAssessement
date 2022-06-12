package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class SignUpPage extends TestBase{
	
	//Page Factory - OR:
		@FindBy(xpath="//*[@id='nav-hamburger-menu']")
		WebElement hamburgerMenu;
		
		@FindBy(xpath="//*[contains(text(),'TV, Appliances, Electronics')]")
		WebElement elctronicsLink;
		
		@FindBy(xpath="//a[contains(text(),'Televisions')]")
		WebElement televisionsLink;
		
		@FindBy(xpath="//a[//*[@class='hmenu hmenu-visible']")
		WebElement scroll;
		
		
		//Initializing the Page Objects:
		public SignUpPage(){
			PageFactory.initElements(driver, this);
		}
		
		//Actions:
		public String validateSignUpPagePageTitle(){
			return driver.getTitle();
		}
		
		public AmazonGpPage performActionsOnSigupPage() {
			clickHamburgerMenu();
			clickElectronicsLink();
			clickTelevisionsLink();
			return new AmazonGpPage();			
		}
		
		private AmazonGpPage clickHamburgerMenu() {
			hamburgerMenu.click();
			return new AmazonGpPage();	
		}
			  
		private void clickElectronicsLink(){ 
			elctronicsLink.click(); 
		}
		  
		private void clickTelevisionsLink() { 
			televisionsLink.click(); 
		}	 
		
}
