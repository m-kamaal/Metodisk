package com.crm.metodisk.pomrepo.contacts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.metodisk.GenericUtils.WebDriverUtility;
import com.crm.metodisk.pomrepo.organisation.OrganisationsHome;

public class CreateNewContacts extends WebDriverUtility {

	WebDriver driver;
	public CreateNewContacts(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	@FindBy(xpath="//input[@name='account_name']/following-sibling::img") //
	private WebElement orgNameLookupIcon;
	
	
	public void createContactWithOrg(String lastNAME, String orgName) throws InterruptedException {
		lastNameEdt.sendKeys(lastNAME);
		orgNameLookupIcon.click();
		
		Thread.sleep(3000);
		switchToWindow(driver, "Accounts&action");
		
		OrganisationsHome oh=new OrganisationsHome(driver);
		oh.getSearchBoxEdt().sendKeys(orgName);
		oh.getSearchBtn().click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		switchToWindow(driver, "Contacts&action");
		saveBtn.click();
	}
	
	
	
	
	
	
	
}
