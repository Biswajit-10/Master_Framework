package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.comcast.genericutility.BaseAnnotationClass;
import com.crm.comcast.pomrepositylib.Home;

public class VtigerCheckBox extends BaseAnnotationClass{
	
	@Test	
	public void clickAllCheckBox()  {
		
		Home h=new Home(driver);
		h.getOrganizationLink().click();

		List<WebElement> lst = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input"));

		//click all the checkbox
		for(int i=1;i<lst.size();i++) {
			lst.get(i).click();
		}

		//unclick last checkbox
		lst.get(lst.size()-1).click();

		//click 5th
		lst.get(5).click();

		//print all organization name
		List<WebElement> lst2 = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a"));
		for(int i=1;i<lst2.size();i++) {

			System.out.println(lst2.get(i).getText());
		}

	}
}	

