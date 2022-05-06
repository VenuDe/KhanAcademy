package Training;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.event.MenuKeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class S2 {
	
WebDriver driver;


String URL = "https://opensource-demo.orangehrmlive.com/";
String URL1 = "https://demo.guru99.com/test/newtours/index.php";
String URL2 = "https://www.google.com/";

@BeforeTest

	public void BT() 
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		
		
	}
	
@Test(enabled = false, priority = 0)

	public void Testcase1() throws InterruptedException 
	{
		driver.get(URL);
		Thread.sleep(4000);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		driver.findElement(By.id("welcome")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"welcome-menu\"]/ul/li[3]/a")).click();
		
		String ActualTitle = "OrangeHRM";
		String ExpectedTitel = driver.getTitle();
		Assert.assertEquals(ExpectedTitel, ActualTitle);
		
	
	}

@Test (enabled = false, priority = 1)
	public void testcase2() throws InterruptedException
	{
	
		driver.get(URL);
		WebElement UN = driver.findElement(By.xpath("//*[@id='txtUsername']"));
		if(UN.isEnabled())
		{
			UN.sendKeys("Venugopal");
			Thread.sleep(3000);
			
			UN.clear();
			UN.sendKeys("Admin");
			Thread.sleep(2000);
		}
		if(UN.isEnabled())
		{
			driver.findElement(By.id("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			
			Thread.sleep(2000);
			driver.findElement(By.linkText("Admin")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_67\"]")).click();
			if (driver.findElement(By.xpath("//*[@id=\"ohrmList_chkSelectRecord_67\"]")).isSelected())
			{
				System.out.println("Selected");
			}
			
		}
			

	}

@Test (enabled = false, priority = 2)

	public void testcase3()
	{
		driver.get(URL);		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
				
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		for (int i=0; i<link.size();i++)
		{
			System.out.println(link.get(i).getText());
		}
		
	}

@Test (enabled = false)
	public void testcase4() throws InterruptedException
	{
		driver.get(URL1);
		driver.findElement(By.name("userName")).sendKeys("Venu");
		
		//i want fetch the attribute
		String value = driver.findElement(By.name("userName")).getAttribute("value");
		System.out.println(value);
		
		
		driver.findElement(By.name("password")).sendKeys("venu123");
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@name='tripType' and @value='oneway']")).click();
		Thread.sleep(3000);
		WebElement dd = driver.findElement(By.name("passCount"));
		
		
		
		//To select value from dropdown we use select keyword
		//this will click onthe drop down
		Select sc = new Select(dd);
		
		//i want to find out how many values are there and how do i get the values
		List <WebElement> values = sc.getOptions();
		System.out.println(values.size());
		for(int i=0; i<values.size();i++)
		{
			System.out.println(values.get(i).getText());
		}
		
		//index at 3 the value 4 to select
		sc.selectByIndex(3);
		sc.selectByVisibleText("3");
		Thread.sleep(3000);
		
		WebElement ee = driver.findElement(By.name("fromPort"));
		Select se = new Select(ee);
		se.selectByVisibleText("New York");
		

	}

@Test (enabled = false)
	public void testcase5() throws InterruptedException
	{
	    driver.get(URL);
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement link = driver.findElement(By.linkText("PIM"));
		Actions act = new Actions (driver);
		act.moveToElement(link).build().perform();
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).build().perform();
		
	
	}

@Test (enabled = false) 
	public void testcase6()
	{
		driver.get(URL);
		Actions act = new Actions (driver);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		act.sendKeys(Keys.TAB).build().perform();
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
				
		act.sendKeys(Keys.ENTER).build().perform();
	}

@Test 
	public void testcase7() throws InterruptedException, AWTException
	{
		driver.get(URL2);
		WebElement link = driver.findElement(By.linkText("Gmail"));
		
		Actions act = new Actions (driver);
		act.contextClick(link).build().perform();
		Robot rc = new Robot();
		rc.keyPress(MenuKeyEvent.VK_DOWN);
		rc.keyPress(MenuKeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
		rc.keyPress(MenuKeyEvent.VK_CONTROL);
		rc.keyPress(MenuKeyEvent.VK_TAB);
		rc.keyRelease(MenuKeyEvent.VK_CONTROL);
				
		Set<String> tab = driver.getWindowHandles();
		for (String windows : tab)
		{
			driver.switchTo().window(windows);
			Thread.sleep(2000);
			driver.get(URL);
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			Thread.sleep(2000);
			driver.close();
			Thread.sleep(2000);
			//driver.quit();
		}
			
 	
	
	}


@AfterTest

	public void AT()
	{	
		
	//driver.close();
		
	}
}
