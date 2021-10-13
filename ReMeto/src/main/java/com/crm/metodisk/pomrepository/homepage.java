package com.crm.metodisk.pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.metodisk.GenericUtils.WebDriverUtility;

public class homepage extends WebDriverUtility {
	
	//INITIALISATION
	WebDriver driver;//null
	public homepage(WebDriver driver)
	{
		
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	
	//FINDING ELEMENTS AND DECLARING
	@FindBy(xpath="//img[contains(@style,'padding-left')][1]")
	private WebElement AdministratorIcon;
	public WebElement getAdministratorIcon() {
		return AdministratorIcon;
	}
	
	@FindBy(linkText="Sign Out")   //LOGOUT 
	private WebElement signoutButton; 
		public WebElement getSignoutButton() {
		return signoutButton;
	}
		
	@FindBy(xpath="//a[contains(text(),'Calendar')]")  //CALENDAR MODULE
	private WebElement calendarButton;
	public WebElement getCalendarButton() {
		return calendarButton;
	}
	
	@FindBy(xpath="//a[contains(text(),'Leads')]")   //LEADS MODULE
	private WebElement leadsButton;
		public WebElement getLeadsButton() {
		return leadsButton;
	}

	@FindBy(xpath="//a[contains(text(),'Organizations')]")   //ORGANISATIONS MODULE
	private WebElement organisationButton;
		public WebElement getOrganisationButton() {
		return organisationButton;
	}

	@FindBy(xpath="//a[contains(text(),'Contacts')]")   //CONTACTS MODULE
	private WebElement contactsButton;
		public WebElement getContactsButton() {
		return contactsButton;
	}
		
	@FindBy(xpath="//a[contains(text(),'Opportunities')]")	 //OPPORTUNITIES MODULE
	private WebElement opportunityButton;
		public WebElement getOpportunityButton() {
		return opportunityButton;
	}

		@FindBy(xpath="//a[contains(text(),'Products')]")	//PRODUCTS MODULE
		private WebElement productsButton;
		public WebElement getProductsButton() {
			return productsButton;
		}

		@FindBy(xpath="//a[contains(text(),'Documents')]")	 //DOCUMENTS MODULE
		private WebElement documentsButton;
		public WebElement getDocumentsButton() {
			return documentsButton;
		}

		/**
		 * Method to perform actions
		 * @param driver
		 */
		public void logout(WebDriver driver)
		{
			mouseHover(driver, AdministratorIcon);
		    signoutButton.click();			    
		}
			
		
}
