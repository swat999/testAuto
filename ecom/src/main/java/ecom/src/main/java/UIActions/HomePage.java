package ecom.src.main.java.UIActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import ecom.src.main.java.testBase.Testbase;

public class HomePage extends Testbase {
	public static final Logger log = Logger.getLogger(HomePage.class.getName());

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}

	@FindBy(xpath = "//a[contains(text(),'Log in')]")
	WebElement loginLink;

	@FindBy(xpath = "//input[@class='button-1 login-button']")
	WebElement logIn;

	public void logIn(String Email,String pword) {

		loginLink.click();
		log("clicked on log in link on the home screen");

		ScreenObjectONloginScrren("Email").sendKeys(Email);
		log("entered valiue in email field on login screen");

		ScreenObjectONloginScrren("Password").sendKeys(pword);
		log("entered valiue in password field on login screen");

		log("To Click on login ");
		logIn.click();
		log("Clicked on login ");

	}

	public void errorLoginVerification() {
		String actual = driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"))
				.getText();
		String expected = actual;
		Assert.assertEquals(actual, expected);
	}
	
	public String SuccessFulllogin() {
		return ScreenObjectOnHompepage("Log out").getText();
	}

	public WebElement ScreenObjectONloginScrren(String name) {

		return driver.findElement(By.xpath("//label[contains(text(),'" + name + "')]/following-sibling::input"));

	}
	public WebElement ScreenObjectOnHompepage(String name) {
		return driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]"));
	}

}
