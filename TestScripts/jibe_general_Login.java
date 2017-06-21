package TestScripts;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class jibe_general_Login extends jibe_general_Open {

	@Test
    public static void main() throws Exception {
		xl_read objExcelFile = new xl_read();
    	
    	String[][] OR=objExcelFile.readExcel(jibe_general_Open.OR_path,"OR_general.xlsx","Login.aspx");
    	String[][] TestData= null;
    	TestData= objExcelFile.readExcel(jibe_general_Open.TestData_path,"TestData1.xlsx","Login");

    	//Verify page is opened 
    	Assert.assertTrue(OR[1][1].equalsIgnoreCase(jibe_general_Open.driver.getTitle()));
    	    	
    	//Enter Username & Password
    	jibe_general_Open.driver.findElement(By.xpath(OR[2][1])).sendKeys(TestData[0][0]);
    	jibe_general_Open.driver.findElement(By.xpath(OR[3][1])).sendKeys(TestData[0][1]);
       	jibe_general_Open.driver.findElement(By.xpath(OR[4][1])).click();
    	jibe_general_Open.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    
    	//Verify login is successful
     		Assert.assertTrue(jibe_general_Open.driver.findElement(By.xpath(".//*[@id='ctl00_HeadLoginView_HeadLoginStatus']")).isDisplayed());

/*     		//close the driver
     		jibe_general_Open.driver.close();
     		System.exit(0); 	*/
	}
}
