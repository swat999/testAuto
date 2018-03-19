package practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.javascript.host.media.webkitAudioContext;

public class Test3 {
	
	public void excelreader() {
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("path"));
			XSSFWorkbook wb  = new XSSFWorkbook(fis);
			XSSFSheet sh = wb.getSheet("sheet1");
			int rowcou = sh.getLastRowNum();
			int colcou = sh.getRow(0).getLastCellNum();
			
			for(int i = 0 ; i<rowcou;i++) {
				XSSFRow row = sh.getRow(i);
				for(int j = 0 ; j<colcou;j++) {
					XSSFCell cell = row.getCell(j);
					cell.getStringCellValue();
				}
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {

		WebDriver driver = new FirefoxDriver();

		WebElement element1 = driver.findElement(By.xpath(""));
		WebElement element2 = driver.findElement(By.xpath(""));
		WebElement element3 = driver.findElement(By.xpath(""));

		Timeouts exp1 = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element1));
		wait.pollingEvery(3, TimeUnit.SECONDS);
		wait.ignoring(ElementNotFoundException.class);

		WebElement wait2 = new FluentWait<WebDriver>(driver).pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(ElementNotFoundException.class).until(ExpectedConditions.visibilityOf(element1));

		wait2.click();

		WebElement wait3 = new FluentWait<WebDriver>(driver).withTimeout(60, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS).ignoring(ElementNotFoundException.class)
				.until(ExpectedConditions.elementToBeClickable(element2));

		element1.sendKeys("ZSSxS");
		element1.sendKeys(Keys.ADD);
		driver.findElement(By.tagName("/a")).click();
		boolean flag1 = element1.isDisplayed();
		boolean flag2 = element1.isEnabled();

		Set<String> handles = driver.getWindowHandles();
		Iterator<String> ite = handles.iterator();
		while (ite.hasNext()) {
			driver.switchTo().window(ite.next());

		}

		driver.getTitle();
		
		Actions action =  new Actions(driver);
		action.moveToElement(element1);
		action.dragAndDrop(element2, element3);
		action.moveToElement(element2).contextClick();
		action.moveToElement(element3).doubleClick();
		action.sendKeys(Keys.ENTER);
		
		File fil = new File("path");
		try {
			FileInputStream fis = new FileInputStream(fil);
			Properties OR = new Properties();
			OR.load(fis);
			Thread.sleep(3000);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		

	}

}
