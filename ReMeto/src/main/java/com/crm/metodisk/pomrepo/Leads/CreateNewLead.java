package com.crm.metodisk.pomrepo.Leads;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.metodisk.GenericUtils.WebDriverUtility;

public class CreateNewLead extends WebDriverUtility{

	WebDriver driver;
	public CreateNewLead(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*LAST NAME TEXT BOX*/
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	/*COMPANY TEXTBOX*/
	@FindBy(name="company")
	private WebElement companyNameEdt;
	public WebElement getCompanyNameEdt() {
		return companyNameEdt;
	}

    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}

    /**
     * This Method enters last name and company name then saves the page
     * @param LastName
     * @param CompanyName
     * @throws InterruptedException 
     */
	public void createLead(String LastName, String CompanyName) throws InterruptedException {
		lastNameEdt.sendKeys(LastName);
		companyNameEdt.sendKeys(CompanyName);
		Thread.sleep(3000);
		saveBtn.click();
		
		
	}

}
