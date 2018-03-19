package UiAuto.ecom.HomePage;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ecom.src.main.java.UIActions.HomePage;
import ecom.src.main.java.testBase.Testbase;

public class TC001_Login_with_Invalid_credential extends Testbase {

	public static final Logger log = Logger.getLogger(TC001_Login_with_Invalid_credential.class.getName());

	@BeforeTest
	public void startTest() throws InterruptedException, IOException {
		init();

	}

	@Test
	public void Login_with_Invalid_credential() throws InterruptedException {
		log.info("============Starting the test=====================");
		HomePage homepage = new HomePage(driver);
		homepage.logIn("ahgsdyha@gzs.com","asdjhkjas");
		homepage.errorLoginVerification();
		captureScreen("login");
		log.info("========================Ending the test=================");

	}

	@AfterTest
	public void endTest() {
		driver.close();

	}

}
