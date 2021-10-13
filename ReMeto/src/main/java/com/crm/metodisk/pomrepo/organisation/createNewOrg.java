package com.crm.metodisk.pomrepo.organisation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createNewOrg {
	WebDriver driver;
	public createNewOrg(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);}
	
@FindBy(name="accountname")
private WebElement orgNameEdt;
public WebElement getOrgNameEdt() {
	return orgNameEdt;}


@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;
public WebElement getSaveBtn() {
	return saveBtn;}

/**
 * This Method enters Organisation Name and clicks on Save button
 * @param OgN
 * @throws InterruptedException 
 */
public void createOrgName(String OgN) throws InterruptedException {
	orgNameEdt.sendKeys(OgN);
	Thread.sleep(3000);
	saveBtn.click();
}

}
