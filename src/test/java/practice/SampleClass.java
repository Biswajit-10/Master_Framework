package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class SampleClass /* extends BaseAnnotationClass */{
	@Test(retryAnalyzer =com.crm.comcast.genericutility.RetryImpClass.class)
	public void create() {
		Reporter.log("this is implementation class retry analyzer",true);
		Assert.fail();
	}

}
