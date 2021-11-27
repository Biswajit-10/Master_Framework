package com.crm.comcast.genericutility;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 
 * @author Biswajit
 *
 */
public class WebDriverUtility {
	/**
	 * implicitly wait and maximize window condition is given in this method
	 * @param driver
	 * @param url
	 */
	public void enterURL(WebDriver driver,String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param time
	 */
	public void implicitWait(WebDriver driver,int time) {
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param driver
	 * @param element
	 * @param time
	 */
	public void explicitWait(WebDriver driver,WebElement element,int waitTime) {
		WebDriverWait wait=new WebDriverWait(driver,waitTime);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForPageTitle(WebDriver driver , String pageTitle){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(pageTitle));
		
	}
	
	public void  waitForElemnetToBeVisible(WebDriver driver , WebElement elemnet){
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(elemnet));
	}
	/**
	 * 
	 * @param driver
	 * @param winHandles
	 * @param realTitle
	 */
	public void moveToWindow(WebDriver driver,String windowParatilTitle) {
		//switchTo new Window
		  Set<String> set = driver.getWindowHandles();
		  Iterator<String> it = set.iterator();
		  while (it.hasNext()) {
			String windowID = it.next();
			driver.switchTo().window(windowID);
			if(driver.getTitle().contains(windowParatilTitle)) {
				break;
			}
		 }
	}
	/**
	 * 
	 * @param driver
	 * @param target
	 */
	public void goToElement(WebDriver driver,WebElement target) {
		Actions a =new Actions(driver);
		a.moveToElement(target).perform();
	}
	
	   /**
	    * This method wait for the element to be clicked , its custom wait created to avoid elemenInterAceptable Exception
	    * @param element
	    * @throws throwable
	    * 
	    */
	   
	   public void waitAndClick(WebElement element) throws InterruptedException
	   {
		   int count = 0;
	       while(count<20) {
		    	   try {
		    	       element.click();
		    	       break;
		    	   }catch(Throwable e){
		    		   Thread.sleep(1000);
		    		   count++;
		    	   }
	       }
	       
	   }
	   /**
	    * this methods enables user to handle dropdown using visible text
	    * @param element
	    * @param option
	    */
	       
	   public void select(WebElement element, String option)
	   {
		   Select select=new Select(element);
		   select.selectByVisibleText(option);
		   
	   }
	   
	   /**
	    * this methods enables user to handle dropdown using index
	    * @param element
	    * @param index
	    */
	      
	   public void select(WebElement element, int index)
	   {
		   Select select=new Select(element);
		   select.selectByIndex(index);   
	   }
	   
	   /**
	    * This method will perform mouse over action
	    * @param driver
	    * @param element
	    */
	   
	   public void mouseOver(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.moveToElement(element).perform();
		   
	   }
	   
	   /**
	    * This method performs right click operation 
	    * @param driver
	    * @param element
	    */
	   public void rightClick(WebDriver driver,WebElement element)
	   {
		   Actions act = new Actions(driver);
		   act.contextClick(element).perform();
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
	    * Cancel Alert
	    * @param driver
	    */
	   public void cancelAlert(WebDriver driver)
	   {
		   driver.switchTo().alert().dismiss();
	   }
	   /**
	    * This method used for scrolling action in a webpage
	    * @param driver
	    * @param element
	    */
	   public void scrollToWebElement(WebDriver driver, WebElement element) {
		   JavascriptExecutor js=(JavascriptExecutor)driver;
		  int y= element.getLocation().getY();
		   js.executeScript("window.scrollBy(0,"+y+")", element);
	   }
	   
	   /**
	    * 
	    * @param driver
	    * @param index
	    */
	    public void switchFrame(WebDriver driver,int index) {
	    	driver.switchTo().frame(index);
	    }   
	    /**
	     * 
	     * @param driver
	     * @param element
	     */
	    public void switchFrame(WebDriver driver,WebElement element) {
	    	driver.switchTo().frame(element);
	    } 
		/**
		 * 
		 * @param driver
		 * @param idOrName
		 */
	    public void switchFrame(WebDriver driver,String idOrName) {
	    	driver.switchTo().frame(idOrName);
	    } 
	    /**
	     * 
	     * @param driver
	     * @param screenshotName
	     * @throws Throwable
	     */
	    public void takeScreenshot(WebDriver driver, String screenshotName) throws Throwable {
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File src=ts.getScreenshotAs(OutputType.FILE);
	    	File dest=new File("./screenshot/"+screenshotName+".PNG");
	    	FileUtils.copyFile(src, dest);
	    }
	    
	    /**
	     * pass enter Key appertain in to Browser
	     * @param driver
	     */
	   public void passEnterKey(WebDriver driver) {
		   Actions act = new Actions(driver);
		   act.sendKeys(Keys.ENTER).perform();
	   } 
	    public void pressVurtualEnterKey() throws AWTException {
	    	
	    	Robot rc=new Robot();
	    	rc.keyPress(KeyEvent.VK_ENTER);
	    	rc.keyRelease(KeyEvent.VK_ENTER);
	    }

	    
}
