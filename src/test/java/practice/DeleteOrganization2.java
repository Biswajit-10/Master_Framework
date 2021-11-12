package practice;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.pomrepositylib.Home;

public class DeleteOrganization2 extends BaseAnnotationClass{
	@Test	
	public void delete()  {
		Home h=new Home(driver);
		h.getOrganizationLink().click();
		
		List<WebElement> lst2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
	
		int num=jlib.getRandomNum(lst2.size()-1);
		 String org = lst2.get(num).getText();
		 System.out.println(org); 
		try {
			driver.findElement(By.xpath("//a[.='"+org+"']/ancestor::tr/td[8]/a[2]")).click();
			Alert a=driver.switchTo().alert();
			a.accept();
		}catch (Exception e) {
			System.out.println("Organization is not present");
		}

	}
}
