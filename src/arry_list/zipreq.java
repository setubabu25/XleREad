package arry_list;

import java.util.ArrayList;

import multiScreenShot.MultiScreenShot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
	

public class zipreq extends method {
	WebDriver driver;
	MultiScreenShot mShot=new MultiScreenShot("./pass/ScreenShot/","sshoot"+timestamp());
	
	@BeforeTest
	public void LaunchBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Personal\\Desktop\\chromedriver.exe");
	//Create A object for chrome driver
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	
	}
			
	@Test(enabled=false)

	public void signin() throws Exception  {
			driver.get("https://www.ziprecruiter.com/login?realm=candidates");
			ArrayList<String> UserName=datainput(0);//number of column in excel sheet 	
			ArrayList<String> Password=datainput(1);
			//array list dynamic data structure which enable add or remove somethign to ur static data structure...also read or write information to a list//keypoint dynamic data structure like you can have interger or string on login or password
			for(int i=0;i<UserName.size();i++){// its reading from 
	
			
				driver.findElement(By.name("email")).sendKeys(UserName.get(i));//send key n i to dynamic and find it from 
				driver.findElement(By.name("password")).sendKeys(Password.get(i));
				driver.findElement(By.className("btn")).click();
				driver.findElement(By.xpath("//*[@id='tabProfile']/div/a[11]")).click();
				Thread.sleep(3001);
				mShot.multiScreenShot(driver);
		}
	}
			
			@Test (priority=2)

			public void search() throws Exception {
				driver.get("https://www.ziprecruiter.com");
				
					ArrayList<String> Search=datainput(2);
					ArrayList<String> Location=datainput(3);//number of column in excel sheet 
					
					//array list dynamic data structure which enable add or remove somethign to ur static data structure...also read or write information to a list//keypoint dynamic data structure like you can have interger or string on login or password
					for(int i=0;i<Search.size();i++){// its reading from 
						
						//obj property
						By Srch=By.id("search1");
						By Loc=By.id("location1");
						By Sbutton=By.xpath(".//*[@id='search_form_1']/div[2]/button");
						
						// we need to create for loop to run it to next time 
						//you need 2 loop 1 to read & 1 to send ti to excel sheet 
						driver.findElement(Srch).sendKeys(Search.get(i));
						driver.findElement(Loc).clear();
						driver.findElement(Loc).sendKeys(Location.get(i));
						driver.findElement(Sbutton).click();
						Thread.sleep(3001);
						//close popup screen
					 
						WebElement popup=driver.findElement(By.xpath("//button[@class='modal-close']"));
						
						if (popup.isDisplayed()){
							
							mShot.multiScreenShot(driver);
							driver.findElement(By.xpath("//button[@class='modal-close']")).click();
							driver.get("https://www.ziprecruiter.com");
						}else  {//validate to show the searck job taking screen shoot
							mShot.multiScreenShot(driver);
							driver.get("https://www.ziprecruiter.com");
							
						}
							
						
				}						
			
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
	