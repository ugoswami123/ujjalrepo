package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Registration {

	WebDriver driver;
	
public Registration(WebDriver driver){
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
@FindBy(css=".signup_form")
WebElement form;
@FindBy(linkText="Register")
public WebElement link;

@FindBy(id="profile_first_name")
public WebElement first_name;

@FindBy(id="profile_last_name")
WebElement last_name;

@FindBy(id="profile_country")
WebElement country;
@FindBy(id="profile_gender_M")
WebElement gender;

@FindAll(@FindBy(xpath="//table[@class='ui-datepicker-calendar']//tbody//a"))
List<WebElement> dob;

@FindBy(id="profile_email")
WebElement email;

@FindBy(id="password")
public WebElement pwd;

@FindBy(id="identity[password_confirmation]")
public WebElement conf_pwd;

@FindBy(id="chk_agree")
public WebElement agreement;

@FindBy(className="ui-datepicker-month")
WebElement month;

@FindBy(className="ui-datepicker-year")
WebElement year;

@FindBy(id="profile_dob")
WebElement date_text;

@FindBy(xpath="//input[@name='commit']")
WebElement create_profile;

public void clickDate(){
	date_text.click();
}

public void clickForm(){
	form.click();
}

public void clickRegistration(){
	link.click();
}

public void setFirstName(String firstname){
	first_name.sendKeys(firstname);
	
}
public void setLastName(String lastname){
	first_name.sendKeys(lastname);
}
	public void setCountry(String cntry){
	Select sl=new Select(country);
	sl.selectByValue(cntry);
	}

	public void selectGender(String gendr){
		gender.click();
	}

public void setDOB(String date){
	
	
}
public void setEmail(String mail){
	email.sendKeys(mail);
}

public void setPassword(String password){
	pwd.sendKeys(password);
}

public void selectMonth(String mnth){
Select s=new Select(month);
s.selectByValue(mnth);
	
}

public void selectYear(String yr){
Select s1=new Select(year);
s1.selectByValue(yr);
}



public void selectDate(String date){
	List<WebElement> ls=dob;
	for(int i=0;i<ls.size(); i++){
		String st=ls.get(i).getText();
		System.out.println("Date is :"+st);
		if(st.equals(date)){
		ls.get(i).click();
			break;
		}
//			
//		ls.get(i).click();
		
	
	
	}
	
		
//	break;
		
}
public void setconfPassword(String conf_password){
	conf_pwd.sendKeys(conf_password);
}

public void checkAgreement(){
	agreement.click();
}




public void createRegistration(){
	create_profile.click();
}


	
}



	


