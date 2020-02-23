package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MapElementsPage {
	

		WebDriver driver;
		
	public MapElementsPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver,this);

}

@FindBy(xpath="//div[@title='Toll']")
WebElement toll_info;

@FindBy(id="mapPublicHome")
WebElement mapView;

@FindBy(id="divRouteCommence")
WebElement route;

@FindBy(css=".buttonPanel.olControlNoSelect div:nth-child(1)")
public WebElement tolls;
@FindBy(css=".buttonPanel.olControlNoSelect div:nth-child(2)")
WebElement camera;

@FindBy(css=".buttonPanel.olControlNoSelect div:nth-child(3)")
public WebElement parking;

@FindBy(css=".buttonPanel.olControlNoSelect div:nth-child(4)")

public WebElement incidents;

@FindBy(css=".buttonPanel.olControlNoSelect div:nth-child(5)")

public WebElement traffic;


@FindBy(css=".speedLegendPanel.olControlNoSelect")

public WebElement legend;

@FindBy(css="a#divTrafficRouteShow")
public WebElement traffic_route;

@FindBy(id="ad_toggle")

public  WebElement ad_togle;

@FindAll(@FindBy(css="#camera_location_singapore li a"))
List<WebElement> cameralist;


@FindBy(css=".left_tab_base div a:nth-child(1)")
public WebElement direction_tab;

@FindBy(id="poi_from")
public WebElement from_direction;

@FindBy(id="poi_to")
public WebElement to_direction;

@FindBy(id="get_direction")
public WebElement direction;

public void getTollInfo(){
	tolls.click();

}
public void getCameraInfo(){
	camera.click();
}
public void getParkingInfo(){
	parking.click();
}
	public void getIncidentInfo(){
		incidents.click();
	}
		
public void getTrafficInfo(){
	traffic.click();
}

public void getDirection(){
	direction_tab.click();
	
}
//public void getTraficRoute(){
//	traffic_route.click();
//	
//}

public  void clickAdd(){
	String st=ad_togle.getAttribute("class");
	System.out.println(st);
	if(st.contains("collapse"))
	
		
	
	ad_togle.click();

	else
		System.out.println("Already collapsed");
	}



public String fromDiection(String from){
	from_direction.clear();
	from_direction.sendKeys(from);
	return from;
	
}
public String toDirection(String to){
	to_direction.sendKeys(to);
	return to;
	
}
public void clickDirection() throws InterruptedException{
	
	direction.click();
	try {
	    WebDriverWait wait=new WebDriverWait(driver,3);
	    wait.until(ExpectedConditions.alertIsPresent());
	    Alert alt = driver.switchTo().alert();
	    System.out.println(alt.getText());
	    alt.accept();
	} catch(UnhandledAlertException noe) {
	    System.out.println("No alert is present");
	}
}
}



