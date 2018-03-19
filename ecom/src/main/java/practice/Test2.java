package practice;

import java.awt.Dialog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Wildcard;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;

public class Test2 {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.pollingEvery(3, TimeUnit.SECONDS);
		wait.ignoring(ElementNotFoundException.class);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement ele1 = driver.findElement(By.xpath(""));
		WebElement ele2 = driver.findElement(By.xpath(""));
		WebElement ele3 = driver.findElement(By.xpath(""));
		WebElement ele4 = driver.findElement(By.xpath(""));
		WebElement ele5 = driver.findElement(By.xpath(""));

		WebElement wait1 = new FluentWait<WebDriver>(driver).pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(ElementNotFoundException.class).until(ExpectedConditions.visibilityOf(ele5));

		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.DAYS);

		Set<String> handles = driver.getWindowHandles();

		for (String s : handles) {
			driver.switchTo().window(s);

		}

		driver.manage().window().maximize();
		Point pos = driver.manage().window().getPosition();
		int a = pos.x;
		int b = pos.y;
		pos.getClass();

		Actions action = new Actions(driver);

		action.moveToElement(ele4).build().perform();
		action.dragAndDrop(ele3, ele2);
		action.moveToElement(wait1).doubleClick().build().perform();
		action.sendKeys(Keys.ADD);

		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
		alert.getText();
		alert.sendKeys("zdfzsd");

		driver.switchTo().frame("AS");
		driver.switchTo().frame(1);
		driver.switchTo().frame(ele4);
		driver.switchTo().defaultContent();

		Select sel = new Select(ele3);
		sel.selectByIndex(1);
		sel.deselectByValue("NASvdh");
		sel.deselectByVisibleText("asdAS");
		sel.deselectAll();
		sel.isMultiple();
		sel.deselectAll();

		EventFiringWebDriver dr = new EventFiringWebDriver(driver);
		
			FileInputStream fis = new FileInputStream(new File("dKJSDjk"));
		
			Scanner sc = new Scanner(fis);
			
		
		Properties or = new Properties();
		or.load(fis);
		or.getProperty("url");
		
		Object[][] chararray = null ;
		
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("shsh");
		int rowcou =sh.getLastRowNum();
		int colcou = sh.getRow(0).getLastCellNum();
		XSSFRow row ;
		XSSFCell cell;
		
		for(int i = 1 ; i<=rowcou;i++) {
			row = sh.getRow(i);
			for(int j = 0; j<colcou;j++) {
				cell = row.getCell(j);
				chararray[i][j]= cell.getStringCellValue();
			}
		}

	}

}
