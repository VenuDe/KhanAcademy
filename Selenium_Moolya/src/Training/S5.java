package Training;

import java.awt.AWTException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class S5 
{

	String URL = "https://demoqa.com/browser-windows";

	String URL1 = "https://www.google.com/";
	String URL2 = "https://demoqa.com/alerts";
	WebDriver driver;
	
@BeforeTest
	public void BT() {
	
	driver = new ChromeDriver();
	
		
}

@Test(enabled = false)
	public void Testcase1() throws InterruptedException, AWTException {
	
	driver.get(URL);
	System.out.println(driver.getTitle());
	
	String Ptab = driver.getWindowHandle();
	for(int i=0; i<=1; i++)
	{
		WebElement link = driver.findElement(By.id("windowButton"));
		Actions act = new Actions(driver);
		act.moveToElement(link).build().perform();
		act.sendKeys(Keys.ENTER).click().build().perform();
	}
//	WebElement link = driver.findElement(By.id("windowButton"));
//	Actions act = new Actions(driver);
//	act.moveToElement(link).build().perform();
//	act.sendKeys(Keys.ENTER).click().build().perform();
//	Thread.sleep(2000);
//	act.sendKeys(Keys.ENTER).click().build().perform();
//	
	Thread.sleep(3000);
	
	//String Ptab = driver.getWindowHandle();
	Set<String> tab = driver.getWindowHandles();
	
	for (String windows : tab)
		{
			driver.switchTo().window(windows);
			driver.get(URL1);
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
				
		  
		}
	driver.quit();
	}
	
@Test
	public void testcase2() throws InterruptedException
	{
		driver.get(URL2);
		driver.manage().window().maximize();
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		
				
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(2000);
		alt.dismiss();
		
		driver.findElement(By.id("close-fixedban")).clear();
		
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(2000);
		alt.sendKeys("We are Moolyans");
		alt.accept();
		
	}
}

