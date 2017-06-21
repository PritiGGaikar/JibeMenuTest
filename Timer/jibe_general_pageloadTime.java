package Timer;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class jibe_general_pageloadTime {
	public static  WebDriver driver=null;

	@Test
    public static void main() throws Exception {
		String url="http://103.24.4.60/jibeseachange/";
		StopWatch pageLoad = new StopWatch();
	
		
		final FirefoxProfile firefoxProfile = new FirefoxProfile();
    	firefoxProfile.setPreference("xpinstall.signatures.required", false);
        driver = new FirefoxDriver(firefoxProfile);
    	driver.get(url);
    	driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_LoginUser_UserName']")).sendKeys("jibeadmin");
    	driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_LoginUser_Password']")).sendKeys("jibe@123");
       	driver.findElement(By.xpath(".//*[@id='ctl00_MainContent_LoginUser_LoginButton']")).click();
      
       	
        pageLoad.start();  
        waitForPageFullyLoaded(driver,0);
        pageLoad.stop();
        System.out.println("Page Load Time after login: " + (pageLoad.getTime()/1000) + " seconds");
        pageLoad.reset();
        
        
        driver.get("http://103.24.4.60/jibeseachange/Technical/PMS/PMSJobProcess.aspx?enc=9OBbXHis5l0EHrIzxPCOzg==");
        pageLoad.start(); 
       
        waitForPageFullyLoaded(driver,0);
        pageLoad.stop();
        System.out.println("Job Status: " + (pageLoad.getTime()/1000) + " seconds");
        pageLoad.reset();
       
        
        
        driver.get("http://103.24.4.60/jibeseachange/Technical/PMS/PMSJobHistory.aspx?enc=oICntrQRdqkDKF/WlJwniQ==");
        pageLoad.start();
        waitForPageFullyLoaded(driver,0);
        pageLoad.stop();
        System.out.println("Job History : " + (pageLoad.getTime()/1000) + " seconds");
        pageLoad.reset();
//            
//        pageLoad.start();
//        driver.get("http://103.24.4.60/jibeseachange/purchase/PendingRequisitionDetails.aspx");
//        waitForPageFullyLoaded(driver,0);
//        pageLoad.stop();
//        System.out.println("Page Load Time for Purchase list: " + (pageLoad.getTime()/1000) + " seconds");
//        pageLoad.reset();
     //   driver.close();
    	 System.exit(0);   	

	
	}
	
	public static boolean waitForPageFullyLoaded(WebDriver driver, int timeoutMs) throws InterruptedException {
		int previous;
		int current = 0;
		int timeSliceMs = 1000;
		do {
		previous = current;
		Thread.sleep(timeSliceMs);
		timeoutMs -= timeSliceMs;
		current = driver.findElements(By.xpath("//*")).size();
		} while(current > previous && timeoutMs > 0);
		if(timeoutMs > 0) {
		return true;
		}
		return false;
		}
	
}
