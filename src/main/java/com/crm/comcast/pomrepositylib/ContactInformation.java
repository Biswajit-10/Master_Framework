package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Biswajit
 *
 */
public class ContactInformation {
	 
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement header;
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;
	
	public void logOut(){
		Actions a =new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"))).perform();
		signoutLink.click();
	}
	
	public ContactInformation(WebDriver driver) {
			PageFactory.initElements(driver,this);
			this.driver=driver;
	}

	public void isContactCreated(String lastname) {
		
	if(header.getText().contains(lastname))
		System.out.println("contact is created successfully");
	else
		System.out.println("contact is not created ");
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

}
