package com.crm.comcast.organizationtest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.pomrepositylib.CreateOrganizations;
import com.crm.comcast.pomrepositylib.Home;
import com.crm.comcast.pomrepositylib.Organization;
import com.crm.comcast.pomrepositylib.OrganizationInfo;
@Listeners(com.crm.comcast.genericutility.ListenerImpl.class)
public class CreateOrg2_Test extends BaseAnnotationClass{
		static {
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
		}
		@Test(groups={"regression"})
		public void createOrgTest() throws  Throwable{
			
			System.out.println("hello");
			System.out.println("hello");
			System.out.println("hello");
			/*Take data from Excel File*/
			String org=flib.getExcelData("organizations",1, 2);		
				
			/*home-page*/
			Home h=new Home(driver);
			h.getOrganizationLink().click();
			/*organisation page*/	
			Organization o=new Organization(driver);
			o.getCreateOrganizationLink().click();
			/*create organisation page */	
			String orgname=org+"_"+jlib.getRandomNum(100);
			CreateOrganizations c=new CreateOrganizations(driver);
			c.getCreateOrganizationTxtBx().sendKeys(orgname);
			c.getSaveBtn().click();
			
			/*organisationInfo page */	
			OrganizationInfo oi=new OrganizationInfo(driver);
			oi.isOrganizationCreated(orgname);
			
		}
			
	}


