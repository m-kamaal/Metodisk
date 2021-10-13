package PracticeTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.metodisk.GenericUtils.BaseClass;
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


public class TC_30withAssert extends BaseClass {
	@Test
	public void tC_30() throws Throwable
	{
		/*READ TEST DATA*/
		String LN = elib.getExelData("lead", 3, 1)+"_"+JavaUtility.getRandomDate();
		String CN = elib.getExelData("lead", 3, 2);
		
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
				
		/*NAVIGATE TO CHILD BROWSER ,PERFORM CHECK/UNCHECK ACTION */
		ConvertLead cl=new ConvertLead(driver);
		wlib.waitForElementVisibility(driver, cl.getOpportunityCheckboxBtn());
		wlib.switchToWindow(driver, "Convert Lead :");
	    cl.getOpportunityCheckboxBtn().click();
	    cl.EnterDate();	    
	    
	   
	    /*VALIDATION OF CHECK BOX */
	    boolean VOrgCb = cl.getOrgCheckboxBtn().isSelected();
	    boolean VOppCb = cl.getOpportunityCheckboxBtn().isSelected();
	    boolean VConCb = cl.getcontactCheckboxBtn().isSelected();
	    System.out.println("Organisation check box is selected="+VOrgCb);
	    System.out.println("Opportunity check box is selected="+VOppCb);
	    System.out.println("Contact check box is selected="+VConCb);
	    Thread.sleep(3000);
		cl.getSaveBtn().click(); 
				
		/*VALIDATING LANDING PAGE*/
		String expTitle= "Administrator - Organizations - vtiger CRM 5 - Commercial Open Source CRM";
		String ActTitle = driver.getTitle();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(ActTitle, expTitle);
		sa.assertAll();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}