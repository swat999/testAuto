package ecom.src.main.java.UIActions;

import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.DerivationControl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import ecom.src.main.java.testBase.Testbase;

public class User_Registration extends Testbase{
	
	public static final Logger log = Logger.getLogger(User_Registration.class.getName());
	
	public User_Registration(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	
	@FindBy(xpath="//input[@id='register-button']")
	WebElement registratinButton;
	
	@FindBy(xpath="//div[@class='result']")
	WebElement regMessage;
	
	public void registration(String sex,String fname,String lname,String email,String companyName,String pword) {
		log("to click on sex");
		radioButton(sex).click();
		log("clicked on sex");
		
		log("to enter first name ");
		inputbox("First name:").sendKeys(fname);
		log("entered data in fst name ");
		
		log("to enter last name ");
		inputbox("Last name:").sendKeys(lname);
		log("entered data in last name ");
		
		
		
		
		log("to enter Email ");
		inputbox("Email").sendKeys(email);
		log("entered data in Email ");

		log("to enter Email ");
		inputbox("Email").sendKeys(companyName);
		log("entered data in Email ");
		
		log("to enter Company name ");
		inputbox("Company name:").sendKeys(lname);
		log("entered data in Company name ");
		
		log("to enter Password ");
		inputbox("Password").sendKeys(pword);
		log("entered data in Password ");
		
		log("to enter Confirm password: ");
		inputbox("Confirm password:").sendKeys(pword);
		log("entered data in Confirm password: ");
		
		log("to click Registration button");
		registratinButton.click();
		log(" clicked Registration button");
		
		
		
		
		
		
	}
	 
	
	public WebElement inputbox(String name) {
		return driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/following-sibling::input "));
	}
	
	public WebElement radioButton(String name) {
		return driver.findElement(By.xpath("//label[contains(text(),'"+name+"')]/preceding-sibling::input"));
	}
	public String registrationMessage() {
		return regMessage.getText();
	}
	
	

}
