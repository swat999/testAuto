package ecom.src.main.java.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Testbase {

	public static final Logger log = Logger.getLogger(Testbase.class.getName());

	public WebDriver driver;
	public Properties pro;
	FileInputStream fis;
	public WebDriverWait wait;
	

	public void init() throws IOException {
		String log4jconfpath = "log4j.properties";
		PropertyConfigurator.configure(log4jconfpath);
//		loadPropertyfile();
		selectBrowser("firefox");
		openUrl("http://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	public void selectBrowser(String name) {
		if (name.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();

		} else if (name.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
			driver = new ChromeDriver();

		}
	}

//	public void loadPropertyfile() throws IOException {
//		  String s = System.getProperty("user.dir");
//		fis = new FileInputStream(new File(s+
//				"/src/main/java/configureFiles/conf.properties"));
//		pro.load(fis);
//		System.out.println(pro.getProperty("browser"));
//		System.out.println(pro.getProperty("Url"));
//
//	}
	public String captureScreen(String fileName) {
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/src/main/java/ecom/src/main/java/scrennShots/";
			destFile = new File((String) reportDirectory + fileName + "_" + formater.format(calendar.getTime()) + ".png");
			FileUtils.copyFile(scrFile, destFile);
			// This will help us to link the screen shot in testNG report
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}
	
	public void xwait(int timeOutInSeconds , WebElement element ) {
		wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.pollingEvery(2, TimeUnit.SECONDS);
		
	}

	public void openUrl(String url) {
		log.info("navigating to url :-" + url);
		driver.navigate().to(url);
		log.info("Maximizing the window");
		driver.manage().window().maximize();
		;
	}
	public void log(String data) {
		log.info(data);
		Reporter.log(data);
	}
	
	public void closeBrowser() {
		log("closing the browser");
		driver.close();
	}

}
