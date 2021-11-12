package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Biswajit
 *
 */
public class OrganizationInfo {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(id="dtlview_Industry")
	private WebElement industry;
	
	@FindBy(id="dtlview_Type")
	private WebElement type;
	
	public OrganizationInfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void isOrganizationCreated(String orgname) {
		if(header.getText().contains(orgname))
			System.out.println("organisation is created successfully");
		else
			System.out.println("organisation is not created ");
	}
	
	public void isIndustryAndTypeCreated(String industryName,String industryType) {
		if(industry.getText().equals(industryName))
			System.out.println("industry is created successfully");
		else
			System.out.println("industry is not created ");
		if(type.getText().equals(industryType))
			System.out.println("industry is created successfully");
		else
			System.out.println("industry is not created ");
	}
	
}
