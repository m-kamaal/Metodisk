
package com.crm.metodisk.GenericUtils;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.compiler.PluginProtos.CodeGeneratorResponse.File;

public class WebDriverUtility {
	
	private static final String JavaUtility = null;
	
	public void Maximise(WebDriver driver) {
		driver.manage().window().maximize();
		
	}

	public void WaitUntilPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
/*
 * This method below wait for the element to be visible
 * @param driver
 * @param element
 */
	
	public void waitForElementVisibility(WebDriver driver, WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/*
	 * This method below wait for the element to be clicked
	 * @param element
	 * @throws throwable
	 */

public void waitAndClick(WebElement element) throws InterruptedException
    {
	  int count=0;
		while(count<40)
		{
			try {
			element.click();
			break;
			    }
			catch(Throwable e)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}

/*
 * This method below enables user to handle drop downusing visible text
 * @param element
 * @param option 
 */

public void SelectOption(WebElement element, String option)
 { 
	Select select=new Select(element);
    select.selectByVisibleText(option);
 }
/*
 * This mehtod below enables user to handle dropdwon by using index
 * @param element
 * @param index
 */

public void SelectOption(WebElement element, int index)
  {
	Select select=new Select(element);
    select.selectByIndex(index);
  }

/*
 * This method below will perform mouse hove action
 * @param driver
 * @param element
 */

public void mouseHover(WebDriver driver, WebElement element)
 {
Actions act=new Actions(driver);
act.moveToElement(element).perform();
 }

/*
 * This method below perform right click operation
 * @param driver
 * @param element
 */

public void rightClick(WebDriver driver, WebElement element)
 {
Actions act=new Actions(driver);
act.contextClick(element).perform();
 }

/*
 * This method helps to switch from one window to another
 * @param driver
 * @param partialWinTitle
 */

public void switchToWindow(WebDriver driver, String partialWinTitle)
 {
	Set<String> window = driver.getWindowHandles();
	Iterator<String> it = window.iterator();
	while(it.hasNext())
	{
		String winId=it.next();
		String title=driver.switchTo().window(winId).getTitle();
		if(title.contains(partialWinTitle))
		{
			break;
		}
	}
 }

/**
 * Accept alert
 * @param driver
 */

public void acceptAlert(WebDriver driver)
 {
	driver.switchTo().alert().accept();
 }

/**
 * Cancel alert
 * @param driver
 */

public void cancelAlert(WebDriver driver)
 {
	driver.switchTo().alert().dismiss();
 }

/**
 * Method used for scrolling action in webpage
 * @param driver
 * @param element
 */
public void scrollToWebElement(WebDriver driver, WebElement element)
 {
	JavascriptExecutor js= (JavascriptExecutor) driver;
	int y=element.getLocation().getY();
	js.executeScript("window.scrollBy(0,"+y+")",element);
 }

/**
 * Method to switch frame by index
 * @param driver
 * @param index
 */
public void switchFrame(WebDriver driver, int index)
 {
	driver.switchTo().frame(index);
 }

/**
 * Method to switch frame by element
 * @param driver
 * @param index
 */
public void switchFrame(WebDriver driver, WebElement element)
 {
		driver.switchTo().frame(element);
 }

/**
 * Method to switch frame by string
 * @param driver
 * @param index
 */
public void switchFrame(WebDriver driver, String idOrName)
 {
	driver.switchTo().frame(idOrName);
 }

public String takeScreenshot(WebDriver driver, String screenshotName) throws Throwable
 {
	String screenshotPath="./screenshot/"+screenshotName+JavaUtility.getCurrentDate()+".PNG";
	TakesScreenshot ts=(TakesScreenshot)driver;
	java.io.File src=ts.getScreenshotAs(OutputType.FILE);
	File dest=new File(screenshotPath);
	File.copy(src, dest);	
	return screenshotName;	
 }

public void pressEnterKey() throws Throwable
 {
	Robot rc=new Robot();
	rc.keyPress(KeyEvent.VK_ENTER);
	rc.keyRelease(KeyEvent.VK_ENTER);
 }




}


