package TestCase;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.DataReader;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LeftMenuPage;
import pages.MapElementsPage;

public class ValidateData extends BaseClass {
	LeftMenuPage lp;
	MapElementsPage mp;
	WebDriverWait wait,wait1;
	DataReader dr;
	@Test(priority=4,description="Search incident location")
	public void searchIncident() throws InterruptedException, IOException{
		dr=new DataReader();
		String location=dr.getLocation();
		System.out.println("Search Location is:"+location);
	lp=new LeftMenuPage(driver);
	Thread.sleep(5000);
	lp.clickAdd();
//	mp=new MapElementsPage(driver);
	
	wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(lp.direction));

lp.clickDirection();
	}
	@Test(priority=5,description="Personal Tab is clicked")
	public void clickPersonal(){
		lp=new LeftMenuPage(driver);	
		wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(lp.personal));
	lp.clickPersonal();
	}
	@Test(priority=6,description="Live Tab is clicked")
	public void clickLive() throws InterruptedException, IOException{
		lp=new LeftMenuPage(driver);
		dr=new DataReader();
		wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(lp.live));
	lp.clickLive();
	}
	@Test(priority=7,description="Verify and store Camera details")
	public void cameraList() throws InterruptedException, IOException{
		lp=new LeftMenuPage(driver);
		wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(lp.camera));
	lp.cameraList();
	wait.until(ExpectedConditions.visibilityOfAllElements(lp.camera_Location));
	lp.clickCameraLocation();
	
	}
	@Test(priority=8,description="Search for incident location")
	public void searchIncidentLocation(){
		lp=new LeftMenuPage(driver);
		wait=new WebDriverWait(driver,10);
	
	wait.until(ExpectedConditions.elementToBeClickable(lp.search_location));
	String location=dr.getLocation();
	lp.searchLocation(location);
	}
	@Test(priority=9,description="Verify Incident List")
	public void getIncidentList() throws InterruptedException{
		
		lp=new LeftMenuPage(driver);
		wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.elementToBeClickable(lp.incident_list));
lp.clickIncident();
	wait.until(ExpectedConditions.visibilityOfAllElements(lp.click_incident));
////	Thread.sleep(3000);
	lp.incidentLists();
//	
	lp.clickIncidentList();
	}
	@Test(priority=10,description="Verify Toll List")
	public void getTollList() throws InterruptedException{
		lp=new LeftMenuPage(driver);
		wait=new WebDriverWait(driver,10);	
		wait.until(ExpectedConditions.elementToBeClickable(lp.toll_list));
	lp.clickToll();
//	Thread.sleep(3000);
//	wait.until(ExpectedConditions.visibilityOfAllElements(lp.tolllists));
	lp.getTollList();
//	Thread.sleep(3000);
	wait.until(ExpectedConditions.visibilityOfAllElements(lp.tolllists));
	lp.getTollData();
	}
}
//}
