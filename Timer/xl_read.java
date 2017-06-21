package Timer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xl_read {

   public String[][] readExcel(String filePath,String fileName,String sheetName) throws IOException{

    File file =    new File(filePath+"\\"+fileName);
    FileInputStream inputStream = new FileInputStream(file);
    Workbook xlWorkbook = null;
    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	String[][] cell=new String[100][100];
    if(fileExtensionName.equals(".xlsx")){
    	xlWorkbook = new XSSFWorkbook(inputStream);

    }

 
    else if(fileExtensionName.equals(".xls")){

    	xlWorkbook = new HSSFWorkbook(inputStream);

    }

      Sheet xlSheet = xlWorkbook.getSheet(sheetName);

    int rowCount = xlSheet.getLastRowNum()-xlSheet.getFirstRowNum();

      for (int i = 0; i < rowCount+1; i++) {

        Row row = xlSheet.getRow(i);
        
        for (int j = 0; j < row.getLastCellNum(); j++) {
		
			cell[i][j]=row.getCell(j).getStringCellValue();
//          System.out.println(cell[i][j]+"-"+i+j);
			
        }
        	

    }
      
      return cell;
         
    }

  
}