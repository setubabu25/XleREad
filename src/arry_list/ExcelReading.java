package arry_list;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;
	
		//you have to take out public void main 
		//method we used read & write you create array...
		//we working on iterator 
		//array always start with 0 & if you skip first one then #1 you will start with 
	//if you want to perform multple 
//blue color as string because it wasn't inside the method 
//before method we use it to initialize the browser...beforemethod basically it will be parents and @test will be your child  

public class ExcelReading {
	WebDriver driver;
	@Test 
	
	public void LaunchBrowser() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Personal\\Desktop\\chromedriver.exe");
		//Create A object for chrome driver
			driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			ArrayList<String> UserName=datainput(0);//number of column in excel sheet 	
			ArrayList<String> Password=datainput(1);
			//array list dynamic data structure which enable add or remove somethign to ur static data structure...also read or write information to a list//keypoint dynamic data structure like you can have interger or string on login or password
			for(int i=0;i<UserName.size();i++){// its reading from 
	
	// we need to create for loop to run it to next time 
			//you need 2 loop 1 to read & 1 to send ti to excel sheet 
			
				
				driver.findElement(By.id("email")).sendKeys(UserName.get(i));//send key n i to dynamic and find it from 
				driver.findElement(By.id("passwd")).sendKeys(Password.get(i));
				driver.findElement(By.id("SubmitLogin")).click();
			
				
				driver.findElement(By.xpath(".//*[@id='header']/div[2]/div/div/nav/div[2]/a")).click();
				Thread.sleep(3001);
		}				
			}
	
	public ArrayList <String> datainput(int colNo) throws IOException  {// variable color red color variable // to handle excel sheet you need execption 
		FileInputStream exofile=new FileInputStream("C:\\Users\\Personal\\Desktop\\datajet.xls");//file path 
		HSSFWorkbook wbofile=new HSSFWorkbook(exofile);//go to excel sheet
		HSSFSheet wsofile=wbofile.getSheet("Sheet1");
		//iterator enables you to cycle through the information  
		Iterator<Row>rowit=wsofile.iterator();//perform action only in java & array 
		
		rowit.next();// as soon as you read one info and go into the next one...
		ArrayList<String> list=new ArrayList<String>();///array list so you can read it over & over again 
		
		while(rowit.hasNext()){//making sure if you dont have info then it will read the empty cell 
			
			list.add(rowit.next().getCell(colNo).getStringCellValue());//first go the column n get the value from the cell 
			//irrator only perform in java & while is when there is value just go on the next one... if my excel sheet have info then read the next one...	
			
		}
		
		System.out.println("List ::::"+list);
		
		return list;//it wont close the method 
		
		
	}
}
