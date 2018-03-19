package UiAuto.ecom.HomePage;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ecom.src.main.java.UIActions.HomePage;
import ecom.src.main.java.UIActions.User_Registration;
import ecom.src.main.java.testBase.Testbase;

public class TC002_Register_new_user extends Testbase {
	
	public static final Logger log = Logger.getLogger(TC002_Register_new_user.class.getName());
	
	@BeforeTest
	public void  start_test() throws IOException {
		init();
		
	}
	@Test
	public void Register_new_user() {
		
		log("==================strat testing===================");
		HomePage homepage = new HomePage(driver);
		log("to click on Register link");
		homepage.ScreenObjectOnHompepage("Register").click();;
		log("clicked on Register link");
		
		User_Registration registration = new User_Registration(driver);
		
		registration.registration("Male", "testf", "lname", "testb@lname.com", "asdfg", "admin123");
		captureScreen("register new user");
		String actual = "Your registration completed";
		String expected = registration.registrationMessage();
		log(expected);
		Assert.assertEquals(actual, expected);
		
		
		log("===================End of the test==================");
		
	}
	@AfterTest
	public void end_test() {
		log("closing browser");
		closeBrowser();
	}
	
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

}
