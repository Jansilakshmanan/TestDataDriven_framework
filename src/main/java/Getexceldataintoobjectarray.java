import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Getexceldataintoobjectarray {
    String testdatapath="C:\\Selenium_projects\\TDD_Framework\\src\\main\\resources\\Testdata_ebay_practice.xlsx";

    @DataProvider
    public  Object[][] readexceldata() throws IOException {
        FileInputStream ip=new FileInputStream(testdatapath);
        Workbook book=new XSSFWorkbook(ip);
        Sheet sheet=book.getSheetAt(0);
        int rowno=sheet.getLastRowNum();
        int colno=sheet.getRow(0).getLastCellNum();
        Object[][] data=new Object[rowno][colno];
        for(int i=0;i<rowno;i++)
        {

            for(int j=0;j<colno;j++)
            { data[i][j]=sheet.getRow(i+1).getCell(j).toString();

            }

        }

        return data;
    }
    //to get data from hashmap using dataprovider
    @Test(priority = 1,dataProvider = "readexceldata")
    public void getdatafromobjectarray(String Test_desc, String Test_name, String Search_text, String Suggestionlist_item, String cartitem_no, String color, String quantity, String Bulk_savings )
    {
         System.out.println("Test Name is: "+Test_name);
        System.out.println("Suggestion list item  is: "+Suggestionlist_item);


    }
}
