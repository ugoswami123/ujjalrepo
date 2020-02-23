package TestCase;

import org.testng.annotations.Test;

import pages.BaseClass;
import pages.Registration;

public class RegistrationTest extends BaseClass {

	Registration reg;
	
	@Test
	public void registerUser() throws InterruptedException{
		reg=new Registration(driver);
		reg.clickRegistration();
	reg.setFirstName("Ujjal");	
	reg.setCountry("India");
	reg.selectGender("Female");
//	reg.setDOB("22-06-1981");
	reg.clickForm();
	reg.setEmail("ujjal.goswami12@gmail.com");
	reg.setPassword("123456");
	reg.clickDate();
	
	reg.selectMonth("5");
	reg.selectYear("1981");
	reg.selectDate("22");
	reg.setPassword("123456");
	reg.setconfPassword("123456");
	reg.checkAgreement();
	reg.createRegistration();
	
	Thread.sleep(3000);
	}
}
