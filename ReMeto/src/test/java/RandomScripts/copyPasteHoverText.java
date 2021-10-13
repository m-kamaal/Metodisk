package RandomScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.metodisk.GenericUtils.WebDriverUtility;

public class copyPasteHoverText extends WebDriverUtility{

	public static void main(String[] args) throws InterruptedException {

    WebDriver driver=new ChromeDriver();
    WebDriverUtility wlib= new WebDriverUtility();
    wlib.Maximise(driver);
    
    driver.get("https://demoqa.com/tool-tips");
    
    wlib.WaitUntilPageLoad(driver);
    
    WebElement ToolTip = driver.findElement(By.id("toolTipButton"));
    
    wlib.mouseHover(driver, ToolTip);
    Thread.sleep(2000);
    String hoverText = driver.findElement(By.xpath("//div[contains(@class,'inner')]")).getText();
	
    driver.findElement(By.id("toolTipTextField")).sendKeys(hoverText);
    System.out.println(hoverText);
    Thread.sleep(5000);
	driver.close();
		

	}

}
