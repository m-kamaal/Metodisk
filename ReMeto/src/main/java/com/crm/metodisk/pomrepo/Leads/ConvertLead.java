package com.crm.metodisk.pomrepo.Leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.metodisk.GenericUtils.JavaUtility;

public class ConvertLead extends JavaUtility {
	WebDriver driver;
	public ConvertLead(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@value='Accounts']")
	private WebElement OrgCheckboxBtn;
	public WebElement getOrgCheckboxBtn() {
		return OrgCheckboxBtn;
	}

	@FindBy(xpath="//input[@value='Potentials']")
	private WebElement OpportunityCheckboxBtn;
	public WebElement getOpportunityCheckboxBtn() {
		return OpportunityCheckboxBtn;
	}

	@FindBy(xpath="//input[@value='Contacts']")
	private WebElement contactCheckboxBtn;
	public WebElement getcontactCheckboxBtn() {
		return contactCheckboxBtn;
	}
	
	@FindBy(name="closingdate")
	private WebElement dateTextbox;
	public WebElement getDateTextbox() {
		return dateTextbox;
	}
	
	@FindBy(name="Save")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void EnterDate() {
		dateTextbox.sendKeys(getCurrentDate2());		
	}
	
}
