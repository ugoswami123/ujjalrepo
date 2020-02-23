package pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver=null;
	private boolean startBrowser = false;
	public String  baseUrl=System.getenv("url");
	
	

	 

		
	     // Also set the path to your geckodriver file 

		
	 
	 
	 
	 @BeforeSuite
	 
	 public void setUp(){
		System.out.println("Base URL is:" +baseUrl );
//		WebDriverManager.chromedriver().setup();
			if(driver ==null){
//				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//				capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--window-size=1920,1080");
				options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT);

				options.addArguments("--start-maximized");
				options.setHeadless(false);//for headless need to set this to true
				 driver=new ChromeDriver(options);
//					ChromeOptions options = new ChromeOptions();
//					driver=new ChromeDriver();
					driver.get(baseUrl);
//					driver.manage().window().maximize();
		
		}
			else
				System.out.println("Browser instance is already launched");
	 }
	 
	 
	
	 public static void takeScreenShot(String folder,String filename) throws IOException{	
		 
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 try {
					 if(folder=="Toll"){
				 	 // now copy the  screenshot to desired location using copyFile //method
			 	FileUtils.copyFile(src, new File("/Users/ujjal/Documents/workspace/Intello3C/MapSynq/Screenshot/Toll/"+filename+".png"));
				 	}
				 }
				 
				 	catch (IOException e)
				 	 {
				 	  System.out.println("File not found");
				 	  }
				 
	 
				 try {
					 if(folder=="Camera"){
				 	 // now copy the  screenshot to desired location using copyFile //method
			 	FileUtils.copyFile(src, new File("/Users/ujjal/Documents/workspace/Intello3C/MapSynq/Screenshot/Camera/"+filename+".png"));
				 	}
				 }
				 catch (IOException e)
			 	 {
			 	  System.out.println("File not found");
			 	  }
	 }
	 
	 public static void takeScreenShotforfailed() throws IOException{		 
			File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				 try {
				 	 // now copy the  screenshot to desired location using copyFile //method
			 	FileUtils.copyFile(src, new File("/Users/ujjal/Documents/workspace/Intello3C/MapSynq/Screenshot/error.png"));
				 	}
				 	 
				 	catch (IOException e)
				 	 {
				 	  System.out.println("File not found");
				 	  }
				 }
	 
@AfterSuite
public void tearDown(){
	driver.close();
	driver=null;
	
}
}
