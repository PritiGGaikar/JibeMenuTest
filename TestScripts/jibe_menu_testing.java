package TestScripts;

import org.junit.Assert;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class jibe_menu_testing extends jibe_general_Open  {
	
  @Test
  public static void main() throws Exception {
		xl_read objExcelFile = new xl_read();
		String[][] TestData=null; 
		TestData=objExcelFile.readExcel(jibe_general_Open.TestData_path,"TestData1.xlsx","Menu");
		int x=0,Total_Menus=0,Menus_Passed=0,Menus_Failed=0,Menus_Skipped=0;
		
try{
	
for (int i=0;i<400;i++){
		String Menu_URL=client_url.concat(TestData[i][0]);	 
  	 	driver.get(Menu_URL);
  	 	
	//Handled for page with no access
  	 	 if(driver.getTitle().equalsIgnoreCase("Home Page"))
  	 	{
  	 		Menus_Skipped=Menus_Skipped+1;
  	 		System.out.println(Menu_URL + "-Access Not Available");
  	 		Thread.sleep(1000);

  	 		
  	 		}
  	// checking page is opened 	 
  	 	else if(driver.getTitle().equalsIgnoreCase(TestData[i][1]))
  	 	{
  	 		Menus_Passed=Menus_Passed+1;
  	 		System.out.println(Menu_URL +"- Open");

  	 		Assert.assertTrue(true);
  	 		Thread.sleep(1000);

  	 		} 
  	 	 
  	//Checking page fails to open 	 
  	 	else
  	 	{
  	 		Menus_Failed=Menus_Failed+1;
  	 		System.out.println(Menu_URL +"-Failed to Open");
  	 		x=x+1;
  	 		}
  	 	Total_Menus=i+1;
  	 	 //break loop if testdatas completed	 
  	 	 if(TestData[i][0]==null){break;}
  	 	 
}
}catch (NullPointerException NPE){}

System.out.println("------------------------");
System.out.println("Total Menus   : "+Total_Menus);
System.out.println("Menus Passed  : "+Menus_Passed);
System.out.println("Menus Failed  : "+Menus_Failed);
System.out.println("Menus Skipped : "+Menus_Skipped);
System.out.println("------------------------");

//Mark testcase Fail if any links failed to open		
if(x>0){Assert.fail();}

//close the driver

  }
  
  
  @AfterClass(alwaysRun = true)
  protected void tearDown() {
      driver.quit();
      driver = null;
  }
}

  

