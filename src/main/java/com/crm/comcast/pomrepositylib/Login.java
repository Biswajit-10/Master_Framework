package com.crm.comcast.pomrepositylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Biswajit
 *
 */
public class Login {
	
	@FindAll({@FindBy(name="user_name"),@FindBy(xpath="//input[@type='text']")})
	private WebElement userNameEdit;
	
	@FindAll({@FindBy(name="user_password"),@FindBy(xpath="//input[@type='password']")})
	private WebElement userPasswordEdit;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@type='submit']")})
	private WebElement loginBtn;
	
	public Login(WebDriver driver){
		PageFactory.initElements(driver,this);
	}

	public void loginToApp(String username,String password) {
		userNameEdit.sendKeys(username);
		userPasswordEdit.sendKeys(password);
		loginBtn.click();
	}

	public void loginToApp() {
		userNameEdit.sendKeys("admin");
		userPasswordEdit.sendKeys("manager");
		loginBtn.click();
	}
	
	public WebElement getUserNameEdit() {
		return userNameEdit;
	}

	public WebElement getUserPasswordEdit() {
		return userPasswordEdit;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
