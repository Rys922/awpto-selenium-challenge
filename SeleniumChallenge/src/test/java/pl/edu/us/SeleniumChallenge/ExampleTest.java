package pl.edu.us.SeleniumChallenge;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class ExampleTest {

	private WebDriver driver;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
/*
	@Test
	public void testGoogle() {
		driver.get("http://google.pl");
		assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void testGoogleSearch() throws InterruptedException {
		driver.get("http://google.pl");
		WebElement searchInput = driver.findElement(By.id("lst-ib"));
		searchInput.sendKeys("instytut informatyki uś");
		searchInput.submit();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Instytut Informatyki")));
		final String previousURL = driver.getCurrentUrl();
		WebElement link = driver.findElement(By.linkText("Instytut Informatyki"));
		link.click();
		Thread.sleep(1000);
		wait.until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return (driver.getCurrentUrl() != previousURL);
			}
        });
		assertEquals("Instytut Informatyki", driver.getTitle());
	}
*/
	@Test
	public void mnozenie() throws InterruptedException, IOException{
		driver.get("http://www.anaesthetist.com/mnm/javascript/calc.htm");
		WebElement dwa = driver.findElement(By.name("two"));
		dwa.click();
		WebElement mnozenie = driver.findElement(By.name("mul"));
		mnozenie.click();
		dwa.click();
		WebElement rowna = driver.findElement(By.name("result"));
		rowna.click();
		Thread.sleep(1000);
		File screenshot =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot, new File("screenshotFileName.png"));

		assertEquals("4", driver.findElement(By.name("Display")).getAttribute("value"));
	}
	
}
