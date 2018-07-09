import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import multiScreenShot.MultiScreenShot;

public class gdata extends getcelldata {


	@BeforeTest
	public void Browser() throws IOException{
		
		openBrowser();	//Method call for open browser
		Screen();//Method foer screenshot
			}
	
	
		@Test(priority=1)
		public void Login() throws IOException{
		//retrive obj properties for login link	
		String loginlink=getdata("Login",2,2);
		//input lonig userid
		////retrive obj properties for login field	
		String id=getdata("Login",2,3);
		//input login userid
		String Idnum=getdata("Login",2,6);
	   //retrive obj properties for pass field	
		String Pass=getdata("Login",2,4);
		//input login userid
		String LPassword=getdata("Login",2,7);
		//click submit
		String submit=getdata("Login",2,5);
						
		//click login link	
		driver.findElement(By.xpath(loginlink)).click();
		//Type lon in id
		driver.findElement(By.xpath(id)).sendKeys(Idnum);
		//type login password
		driver.findElement(By.xpath(Pass)).sendKeys(LPassword);
		Screen();//if pass then take screenshot
		//click submit
		driver.findElement(By.xpath(submit)).click();
		}
		
		@Test(priority=2)
		public void search() throws IOException{
			//retrive Search object propertise
			String Search=getdata("Search",2,1);
			//retrive test data
			String SInput=getdata("Search",2,3);
			//retrive Search button object propertise
			String clikSh=getdata("Search",2,2);
			//search for product
			driver.findElement(By.xpath(Search)).sendKeys(SInput);
			Screen();//if pass then take screenshot
			driver.findElement(By.xpath(clikSh)).click();
					
		}
		@Test(priority=3)
		public void  register() throws IOException{
			//clike login link
			String Regilink=getdata("Login",2,2);
			//click register
			String CkickRegi=getdata("Regi",2,1);
			//retrive email object propertise
			String Email=getdata("Regi",2,2);
			//retrive test data
			String REmail=getdata("Regi",3,2);
			//retrive confrome email object propertise
			String CEmail=getdata("Regi",2,3);
			////retrive test data
			String RCemail=getdata("Regi",3,3);
			//retrive pasword object propertise
			String password=getdata("Regi",2,4);
			//retrive test data
			String Rpass=getdata("Regi",3,4);
			//retrive confrom pasword object propertise
			String Cpass=getdata("Regi",2,5);
		     //retrive test data
			String Crpass=getdata("Regi",3,4);
			//retrive Newslater object propertise
			String Newslater=getdata("Regi",2,6);
			//retrive Create button  object propertise
			String create=getdata("Regi",2,7);
			//click login link
			driver.findElement(By.xpath(Regilink)).click();
			//click create a account button
			driver.findElement(By.xpath(CkickRegi)).click();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			//type email address
			driver.findElement(By.xpath(Email)).sendKeys(REmail);
			//type confrom email address
			driver.findElement(By.xpath(CEmail)).sendKeys(RCemail);
			//type password
			driver.findElement(By.xpath(password)).sendKeys(Rpass);
			//type confrom password
			driver.findElement(By.xpath(Cpass)).sendKeys(Crpass);
			//validate newslater selected
			System.out.println(driver.findElement(By.xpath(Newslater)).isSelected());
			Screen();//if pass then take screenshot
			//Create a account
			driver.findElement(By.xpath(create)).click();
			
			
		
		}
	

	@AfterMethod///if test fail it will take screen shot and save it in fail folder 
	public void Failtest(ITestResult Result) {
		if (ITestResult.FAILURE==Result.getStatus()) {
			   try {
				  MultiScreenShot FmShot=new MultiScreenShot("./Fail/ScreenShot/","sshoot"+timestamp());
				 FmShot.multiScreenShot(driver);
			   System.out.println("Fail Test Takes Screen Shoot succesfully");
			    
			   }catch(Exception e) {
			    
			   }
			   }
			     
			  }
	
	@AfterTest
	public void closeDriver(){
		driver.quit();
		
	}
	
}



