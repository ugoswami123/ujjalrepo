package pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenuPage extends BaseClass {

	WebDriver driver;
	String toll_name;
	
	public LeftMenuPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);

}
	@FindBy(css=".left_tab a:nth-child(1)")
	public WebElement direction;
	
	@FindBy(css=".left_tab a:nth-child(2)")
	public WebElement personal;
	
	@FindBy(css=".left_tab a:nth-child(3)")
public WebElement live;
	
	@FindAll(@FindBy(css="#camera_location_singapore div"))
	public List<WebElement> cameralist;
	
	@FindBy(xpath="//h2[contains(text(),'Cameras')]")
	public WebElement camera;
	
	@FindAll(@FindBy(css="#camera_location_singapore div a"))
	public List<WebElement> camera_Location;
	
	@FindAll(@FindBy(css="#search_incident_singapore li"))
	public List<WebElement> incidentlists;
	
	@FindBy(id="ad_toggle")

	public  WebElement ad_togle;
	@FindBy(id="txtSearchCamerasingapore")
	public WebElement search_location;
	
	@FindBy(xpath="//h2[contains(text(),'Incidents')]")
	public WebElement incident_list;
	
	@FindBy(xpath="//h2[contains(text(),'Tolls')]")
	public WebElement toll_list;
	
	@FindAll(@FindBy(css="#erp_locationsingapore li a"))
	public List<WebElement>tolllists;
	
	@FindBy(css="#car_m tbody")
	public WebElement toll_data;
	
	
	
	@FindAll(@FindBy(css="ul.incident a"))
	public List<WebElement> click_incident;
	
	public  void clickAdd(){
		
		String st=ad_togle.getAttribute("class");
		System.out.println(st);
		if(st.contains("collapse"))
		
			
		
		ad_togle.click();

		else
			System.out.println("Already collapsed");
		}
	
	
	public void clickDirection(){
		direction.click();
		
	}
public void clickPersonal(){
	personal.click();
	
}

public void clickLive(){
	live.click();
}


public void cameraList(){
	camera.click();
	List<WebElement> ls=cameralist;
	System.out.println("No of place where camera is installed is:"+ls.size());
//	for(int i=0;i<ls.size();i++){
//		String location=ls.get(i).getText();
//		
//		System.out.println("Camera Location is:"+location);
//	}
}

public void clickCameraLocation() throws InterruptedException, IOException{
	List<WebElement> list=camera_Location;
	for(int i=0;i<list.size();i++){
		camera_Location.get(i).click();
		System.out.println("Camera is clicked for location:"+list.get(i).getText());
//		Thread.sleep(1000);
		takeScreenShot("Camera",list.get(i).getText());
		
		
	}
	
}

public void searchLocation(String location){
	search_location.sendKeys(location);
	
}

public void clickIncident(){
	incident_list.click();
	
}

public void incidentLists() throws InterruptedException{
	List<WebElement> incident=incidentlists;
	
	
	for(int i=0;i<=incident.size()-1;i++){
		String incident1=incident.get(i).getText();
		System.out.println("Total no of incident for current date is:"+incident.size());
		System.out.println("List of incident for today is:"+incident1);
//		Thread.sleep(1000);
		
	}
}

public void clickIncidentList(){
	List<WebElement>clicklist=click_incident;
	for(int i=0;i<clicklist.size();i++){
		System.out.println(clicklist.get(i).getText()+"Incident is clicked");
	}
}

public void clickToll(){
	toll_list.click();
}
public void getTollList(){
	List<WebElement>toll=tolllists;
	for(int i=0;i<toll.size();i++){
		 toll_name=toll.get(i).getText();
		System.out.println(toll_name +" toll info is displayed");
	}
}


public void getTollData() throws InterruptedException{
	
	List<WebElement>tollinfo=tolllists;
	
	
	
		for(int j=0;j<tollinfo.size();j++){
			tollinfo.get(j).click();
			try {
				takeScreenShot("Toll",tollinfo.get(j).getText());
				System.out.println(tollinfo.get(j).getText() + "toll data is stored");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			System.out.println(el.getText());
			Thread.sleep(1000);
//			for(int i=0;i<t_list.size();i++){
//				System.out.println(t_list.size());
////		String toll_location=t_list.get(i).getText();
//		System.out.println("Toll Data is:"+t_list.get(i).getText());
//		
//	}
}
}

//public void getTollListData(){
//	List<WebElement>t_list=toll_data;
//	for (int i=0;i<t_list.size();i++){
//		String data=t_list.get(i).getText();
//		System.out.println("Toll details is:" +data);
//	}
//}
}
