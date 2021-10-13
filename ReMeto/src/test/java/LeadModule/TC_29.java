package LeadModule;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.metodisk.GenericUtils.ExcelUtility;
import com.crm.metodisk.GenericUtils.FileUtility;
import com.crm.metodisk.GenericUtils.JavaUtility;
import com.crm.metodisk.GenericUtils.WebDriverUtility;
import com.crm.metodisk.pomrepo.Leads.ConvertLead;
import com.crm.metodisk.pomrepo.Leads.CreateNewLead;
import com.crm.metodisk.pomrepo.Leads.LeadInfo;
import com.crm.metodisk.pomrepo.Leads.LeadsHome;
import com.crm.metodisk.pomrepository.homepage;
import com.crm.metodisk.pomrepository.login;


public class TC_29 {
	@Test
	public void tC_29() throws Throwable
	{
		/*CREATING OBJECTS*/
		FileUtility fu=new FileUtility();
		ExcelUtility eu=new ExcelUtility();
		WebDriverUtility wu=new WebDriverUtility();
		
		/*READ COMMON DATA*/
		String URL = fu.getPropertyKeyValue("url");
		String BROWSER = fu.getPropertyKeyValue("browser");
		String USERNAME = fu.getPropertyKeyValue("username");
		String PASSWORD = fu.getPropertyKeyValue("password");
		
		/*READ TEST DATA*/
		String LN = eu.getExelData("lead", 3, 1)+"_"+JavaUtility.getRandomDate();
		String CN = eu.getExelData("lead", 3, 2);
		
		WebDriver driver=null;
		
		/*LAUNCH BROWSER AND OPEN WEBAPP*/
		if(BROWSER.equals("chrome")) {
			driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver=new ChromeDriver();
		}
		else driver=new ChromeDriver();
				
		driver.get(URL);
		
		/*LOGIN TO APP*/
		login l =new login(driver);
		l.loginToApp(USERNAME, PASSWORD);
		
		/*NAVIGATE TO LEAD PAGE*/
		homepage hp=new homepage(driver);
		hp.getLeadsButton().click();
		Thread.sleep(2000);
		
		/*NAVIGATE TO CREATE NEW LEAD PAGE*/
		LeadsHome lh=new LeadsHome(driver);
		lh.getCreateLeadBtn().click();
		
		/*CREATE LEAD AND SAVE IT*/
		CreateNewLead cnl=new CreateNewLead(driver);
		cnl.createLead(LN, CN);
		Thread.sleep(4000);
		
		/*NAVIGATE TO CONVERTLEAD*/
		LeadInfo li=new LeadInfo(driver);
		li.getConvertLeadBtn().click();
				
		/*NAVIGATE TO CHILD BROWSER ,PERFORM CHECK/UNCHECK ACTION AS PER TC AND SAVE*/
		ConvertLead cl=new ConvertLead(driver);
		wu.waitForElementVisibility(driver, cl.getOpportunityCheckboxBtn());
		wu.switchToWindow(driver, "Convert Lead :");
	    cl.getOpportunityCheckboxBtn().click();
	    cl.EnterDate();	    
	    cl.getSaveBtn().click();
	    
	    /*LOGOUT AND CLOSE BROWSER*/
	    hp.logout(driver);
	    driver.close();
				
	}

}