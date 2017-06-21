package TestScripts;

import java.util.Scanner;

//import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class jibe_general_Open {
	
	public static  WebDriver driver=null;
	public static String proj_loc="C:\\Users\\Priti\\workspace\\JibeSmoketest\\";
	public static String client_url,config_path,OR_path,TestData_path;

	@Test
    public static void main() throws Exception {
		String client =null;
		
    	//If client URL taking based on User Input
        Scanner userinput = new Scanner(System.in); 
    	System.out.println("Enter a Client Name: ");
    	client = userinput.next();
    	
		//If client URL taking directly
		//client="jibews";
		//set file paths for Input files
    	
    	    	    	    	
    	xl_read objExcelFile = new xl_read();
    	config_path = proj_loc+"//JiBeConfig//";
    	OR_path = proj_loc+"//Objects//";
    	TestData_path = proj_loc+"//TestData//";
    	
    	String[][] client_config=objExcelFile.readExcel(config_path,"ClientConfig.xlsx",client);
    	client_url=client_config[0][1];
    	
    	String chrome=proj_loc+"//Objects//chromedriver.exe";
    	System.setProperty("webdriver.chrome.driver", chrome);
    	driver = new ChromeDriver();
    	driver.get(client_url);
    	
    	driver.manage().window().maximize();

    	Assert.assertTrue(driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[3]/div[1]/div[1]/img")).isDisplayed());
    	
    	/*     		//close the driver
 		jibe_general_Open.driver.close();
 		System.exit(0); 	*/
    }
	
 
}