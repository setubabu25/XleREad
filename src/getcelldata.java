 import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xerces.util.SynchronizedSymbolTable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;

import multiScreenShot.MultiScreenShot;

public class getcelldata {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	public static WebDriver driver;
	//method for time
	public static String timestamp() {
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	//Method for Retrive Data from XLe
public static String getdata (String sheetname,int cellnum,int rownum) throws IOException{
	
	fis =new FileInputStream("/Xleread/egg site.xlsx");
	wb=new XSSFWorkbook(fis);
	sheet=wb.getSheet(sheetname);
	row=sheet.getRow((rownum)-1);
	cell=row.getCell((cellnum)-1);
	return cell.getStringCellValue();
	
}
//Method for screen shoot
public static void Screen() throws IOException{
	MultiScreenShot mShot=new MultiScreenShot("./pass/ScreenShot/","sshoot"+timestamp());
	mShot.multiScreenShot(driver);
	System.out.println("Passed Method take screenshot successfully");
		
}
//Method for open browser
public void openBrowser() throws IOException{
	  String Url=getdata("Login",2,1);
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Personal\\Desktop\\chromedriver.exe");
		//Create A object for chrome driver
		driver= new ChromeDriver();
		driver.get(Url);
		driver.manage().window().maximize();
		System.out.println("Browser open");
}


}