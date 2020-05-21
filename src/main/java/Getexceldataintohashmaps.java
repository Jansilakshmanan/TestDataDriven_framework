import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Getexceldataintohashmaps {
    String testdatapath="C:\\Selenium_projects\\TDD_Framework\\src\\main\\resources\\Testdata_ebay_practice.xlsx";

    @DataProvider
    public   Object[][] getdataintohashmaparray() throws IOException {

        FileInputStream ip = new FileInputStream(testdatapath);
        Workbook book= new XSSFWorkbook(ip);
        Sheet sheet=book.getSheetAt(0);
        int totalrow=sheet.getLastRowNum();
        int totalcol=sheet.getRow(0).getLastCellNum();
        Object[][] data=new Object[totalrow][1];
        for(int i=0;i<totalrow;i++)
        {
            HashMap<String,String> map=new HashMap<String,String>();
            for(int j=0;j<totalcol;j++)
            {
                map.put(sheet.getRow(0).getCell(j).toString(),sheet.getRow(i+1).getCell(j).toString());


            }
            data[i][0]=map;
        }

        return data;

    }

//to get data from hashmap using dataprovider
@Test(priority = 1,dataProvider = "getdataintohashmaparray")
public void getdatafrommap(HashMap<String,String> map) throws IOException {

    System.out.println(map);
    System.out.println("Get respective values of key:"+map.get("Test_desc"));
   System.out.println("Get all the values:"+map.values());
    System.out.println("Get all the keys:"+map.keySet());
    for(Map.Entry<String,String> e :map.entrySet())
    {
        if(e.getValue().equalsIgnoreCase("watches women"))
        {
            System.out.println("Iterate and get the values :" + e.getKey());
        }
    }
    }

    //Advantages of using Hashmaps with TestNG Dataprovider in Data Driven Testing:
    // * parameters need not be passed to the test method
          // This is especially useful when the excel data has many columns(say 50 colns),we cannot pass 50 parameters to the test method
    // * values can be retrieved as key,value pairs
    // * Additional data that need not be from the excel can also be manually added in hashmaps whenever needed,
    //    whereas in object array,array size cannot be altered
}
