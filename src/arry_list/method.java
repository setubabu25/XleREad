package arry_list;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;

public class method {
static WebDriver driver;

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


	//method for time
	public static String timestamp() {
	return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	

}
