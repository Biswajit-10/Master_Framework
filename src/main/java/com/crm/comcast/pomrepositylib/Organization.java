package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericutility.WebDriverUtility;
/**
 * 
 * @author Biswajit
 * Organization look-up page shows same data as Organization page show we have added look-up page
 * Here
 */
public class Organization {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationLink;

	@FindBy(name="accountname")
	private WebElement createOrganizationTxtBx;
	
	@FindBy(id="search_txt")
	private WebElement searchTxt;
	
	@FindBy(name="search")
	private WebElement searchBtn;
	
	
	public void selectOrganisation(String organisationName) {
		driver.findElement(By.linkText(organisationName)).click();
	}
	
	public WebElement getCreateOrganizationTxtBx() {
		return createOrganizationTxtBx;
	}

	public WebElement getSearchTxt() {
		return searchTxt;
	}
	
	public void switchTabsOrWindow (String windowParatilTitle) {
		WebDriverUtility wu=new WebDriverUtility();
		wu.moveToWindow(driver,windowParatilTitle );
		
	}	
	
	public void switchWindowToNewContactPage () {
		WebDriverUtility wu=new WebDriverUtility();
		wu.moveToWindow(driver,"Administrator" );
		
	}	
	
	public Organization(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getCreateOrganizationLink() {
		return createOrganizationLink;
	}

	public void clickOncreate() {
		createOrganizationLink.click();
	}
	
	public void enterAndSearchAndClick(String organisationName) {
		searchTxt.sendKeys(organisationName);
		searchBtn.click();
//		driver.findElement(By.linkText(organisationName)).click();
		driver.findElement(By.xpath("//a[.='"+organisationName+"']")).click();
		
//		other than xpath,cssSelector we can pass string value directly in other locators
	}
	
	
}
