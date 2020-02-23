package TestCase;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import Utility.DataReader;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.LeftMenuPage;
import pages.MapElementsPage;

public class ClickMenuTest extends BaseClass {
	LeftMenuPage lp;
	MapElementsPage mp;
	WebDriverWait wait,wait1;
	DataReader dr;
	@Test(description="Verify incidents,camera and toll data")
	public void clickMenuTest() throws InterruptedException, IOException{
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

	
	wait.until(ExpectedConditions.elementToBeClickable(lp.personal));
	lp.clickPersonal();

	wait.until(ExpectedConditions.elementToBeClickable(lp.live));
	lp.clickLive();

	wait.until(ExpectedConditions.elementToBeClickable(lp.camera));
	lp.cameraList();
	wait.until(ExpectedConditions.visibilityOfAllElements(lp.camera_Location));
	lp.clickCameraLocation();
	wait.until(ExpectedConditions.elementToBeClickable(lp.search_location));
	lp.searchLocation(location);
	wait.until(ExpectedConditions.elementToBeClickable(lp.incident_list));
	lp.clickIncident();
	wait.until(ExpectedConditions.visibilityOfAllElements(lp.click_incident));
//	Thread.sleep(3000);
	lp.incidentLists();
	
	lp.clickIncidentList();
	lp.clickToll();
	Thread.sleep(3000);
	lp.getTollList();
	Thread.sleep(3000);
	lp.getTollData();

}
}
