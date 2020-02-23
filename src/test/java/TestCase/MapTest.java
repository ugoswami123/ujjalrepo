package TestCase;

import org.testng.annotations.Test;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.BaseClass;
import pages.MapElementsPage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class MapTest extends BaseClass {
	MapElementsPage mp;
	WebDriverWait wait1;
	@Test(priority=1,description="Verify  incident tab is clicked in the map" )
	public void getMapLocation() throws InterruptedException{
//		SikuliFirefoxDriver dr=new SikuliFirefoxDriver();
//		ImageElement image;
//		dr.findI
		
//	WebDriverManager.firefoxdriver().setup();
//	String st=driver.getPageSource();
//	System.out.println(st);
	
	mp=new MapElementsPage(driver);
	
Thread.sleep(5000);
	mp.clickAdd();
	
	wait1=new WebDriverWait(driver,3);
	wait1.until(ExpectedConditions.elementToBeClickable(mp.incidents));
	mp.getIncidentInfo();
	
	}
	@Test(priority=2,description="Verify parking tab is clicked in the map")
	public void clickParking() throws InterruptedException{
		mp=new MapElementsPage(driver);
		wait1=new WebDriverWait(driver,3);
	wait1.until(ExpectedConditions.elementToBeClickable(mp.parking));
//	Thread.sleep(3000);
	mp.getParkingInfo();
//	Thread.sleep(3000);
	}
	@Test(priority=3,description="Verify toll tab is clicked in the map")
	public void clickToll() throws InterruptedException{
		mp=new MapElementsPage(driver);
		wait1=new WebDriverWait(driver,3);
	
	wait1.until(ExpectedConditions.elementToBeClickable(mp.tolls));
	mp.getTollInfo();
//	Thread.sleep(3000);
	wait1.until(ExpectedConditions.elementToBeClickable(mp.traffic));
	mp.getTrafficInfo();
//	Thread.sleep(3000);
	}
	@Test(description="Verify whether direction is clicked and search for direction ")
	public void searchDirection() throws InterruptedException{
		mp=new MapElementsPage(driver);
		wait1=new WebDriverWait(driver,3);
	
//	Thread.sleep(3000);
//	mp.getCameraList();
//	mp.getTraficRoute();
	wait1.until(ExpectedConditions.elementToBeClickable(mp.direction_tab));
	mp.getDirection();
	mp.fromDiection("ANSON ROAD");
	mp.toDirection("Castlery");
	wait1.until(ExpectedConditions.elementToBeClickable(mp.direction));
	mp.clickDirection();
	
//	driver.get("https://www.google.com/maps/@1.3596143,103.8120849,12z/data=!10m1!1e1!12b1?source=apiv3&amp;rapsrc=apiv3");
//Thread.sleep(3000);
//	//driver.findElement(By.id("searchbox-directions")).click();
//Actions act=new Actions(driver);
//for(int i=0;i<1;i++){
//driver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL,Keys.ADD));
	//	Thread.sleep(10000);
//	driver.switchTo().frame(0);
//	mp.tollInfo();
}
		}	






