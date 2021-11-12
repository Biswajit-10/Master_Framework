package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home {
	WebDriver driver;
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	@FindBy(xpath="//img[@style='padding: 0px;padding-left:5px']")
	private WebElement userImg;
	
	public void logOut(){
		Actions a =new Actions(driver);
		a.moveToElement(userImg).perform();
		signoutLink.click();
	}
	
	public Home(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement getOrganizationLink() {
		return OrganizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}
		
}
