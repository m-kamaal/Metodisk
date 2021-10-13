package com.crm.metodisk.pomrepo.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationsHome {
	WebDriver driver;
	
	public OrganisationsHome(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 @FindBy(xpath="//img[@alt='Create Organization...']")
	 private WebElement createOrg;
	public WebElement getCreateOrg() {
		return createOrg;
	}
	 
	@FindBy(name="search_text")
	private WebElement searchBoxEdt;
	public WebElement getSearchBoxEdt() {
		return searchBoxEdt;
	}
	 
	@FindBy(name="search")
	private WebElement searchBtn;
	public WebElement getSearchBtn() {
		return searchBtn;
	}

}
