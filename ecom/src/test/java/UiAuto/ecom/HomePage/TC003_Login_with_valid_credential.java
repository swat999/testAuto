package UiAuto.ecom.HomePage;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ecom.src.main.java.UIActions.HomePage;
import ecom.src.main.java.testBase.Testbase;

public class TC003_Login_with_valid_credential extends Testbase {

	@BeforeTest
	public void start_test() throws IOException {
		init();

	}

	@Test
	public void Register_new_user() {

		log("===============Start test====================");
		HomePage homepage = new HomePage(driver);
		homepage.logIn("testb@lname.com","admin123");
		String actual ="Log out";
		String expected = homepage.SuccessFulllogin();
		captureScreen("loginSucces");
		Assert.assertEquals(actual, expected);
		log("================end test=================");

	}

	@AfterTest
	public void end_test() {

		closeBrowser();
	}

}
