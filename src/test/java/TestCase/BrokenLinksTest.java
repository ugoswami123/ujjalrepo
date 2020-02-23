package TestCase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.BaseClass;
import pages.CommonLinksPage;

public class BrokenLinksTest extends BaseClass {
	CommonLinksPage cp;

	
	

@Test(priority=1,description="Verify all the links")
public void getLinks(){
	
	cp=new CommonLinksPage(driver);
	List<WebElement> link=cp.links;
	System.out.println("Total links are "+link.size());
	for(int i=0;i<link.size();i++)
	System.out.println("All the Links areas follows: "+link.get(i).getText());
	
	
	
	
	for(int i=0;i<link.size();i++)
	{
		
		WebElement ele= link.get(i);
		
		String url=ele.getAttribute("href");
		
		verifyLinkActive(url);
		
}
	}

	public static void verifyLinkActive(String linkUrl)
	{
        try 
        {
           URL url = new URL(linkUrl);
           
           HttpURLConnection httpURLConnect=(HttpURLConnection)url.openConnection();
           
           httpURLConnect.setConnectTimeout(3000);
           
           httpURLConnect.connect();
           
           if(httpURLConnect.getResponseCode()==200)
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage());
            }
          if(httpURLConnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND)  
           {
               System.out.println(linkUrl+" - "+httpURLConnect.getResponseMessage() + " - "+ HttpURLConnection.HTTP_NOT_FOUND);
            }
        } catch (Exception e) {
           
        }
    } 
	
		
	}
