package TestScripts;

import org.testng.annotations.Test;

public class MytestFile  extends jibe_general_Open {
	  @Test
	  public static void main() throws Exception {
			xl_read objExcelFile = new xl_read();
			String[][] TestData=objExcelFile.readExcel(jibe_general_Open.TestData_path,"TestData1.xlsx","Login");
			
			for (int i=0;i<7;i++){
				for (int j=0;j<4;j++){
					System.out.println("Row:"+i+",Column:"+j);
					System.out.println(TestData[i][j]);
				}
			}
	  }
	  

}