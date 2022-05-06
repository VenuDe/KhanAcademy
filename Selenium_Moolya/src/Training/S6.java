package Training;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class S6 {
	
	String URL1 = "https://demo.guru99.com/test/newtours/index.php";
	String URL = "https://demoqa.com/frames";
	String URL2 = "https://opensource-demo.orangehrmlive.com/";
	String URL3 = "https://demoapp.skillrary.com/";
	
	WebDriver driver;
	@BeforeTest
	public void BT()
	{
		driver = new ChromeDriver();
		
	}
	
@Test(enabled = false)
	public void testcase1() throws InterruptedException
	{
	driver.get(URL1);
	String underconstruction = "Under Construction: Mercury Tours";
	List<WebElement> link = driver.findElements(By.tagName("a"));
	//i want to extract the text of each link
	String[] linktext =new String [link.size()];
	int i=0;
	for(WebElement e : link)
	{
		linktext[i] = e.getText();
		i++;
	}
	
	for(String t : linktext)
	{
	driver.findElement(By.linkText(t)).click();
	if(driver.getTitle().equals(underconstruction))
	{
		System.out.println( t + "is Under Construction");
	}
	else
	{
		System.out.println(t +"is working");
	}
	driver.navigate().back();
	Thread.sleep(3000);
	driver.navigate().refresh();
	}
	
	
	}

@Test(enabled = false)
 public void testcase2() throws InterruptedException
 {
	driver.get(URL);
	driver.manage().window().maximize();
	Actions act = new Actions(driver);
	act.sendKeys(Keys.PAGE_DOWN).build().perform();
	Thread.sleep(3000);
	act.sendKeys(Keys.PAGE_UP).build().perform();
	

 }

@Test(enabled = false)
	public void testcase3() throws InterruptedException
	{
		driver.get(URL2);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String URL = js.executeScript("return document.URL").toString();
		System.out.println(URL);
		
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		
		String domain = js.executeScript("return document.domain").toString();
		System.out.println(domain);
		
		//getting innertext by driver
		String name = driver.findElement(By.id("divUsername")).getText();
		System.out.println(name);
		
		//getting innertext by js
		String innertext = js.executeScript("return document.getElementById('divUsername').innerText;").toString();
		System.out.println(innertext);
		
		Thread.sleep(3000);
		js.executeScript("history.go[0]");
		
		//by driver
		String Text = driver.findElement(By.id("content")).getText();
		System.out.println(Text);
		
	}

@Test
	public void testcase4() throws InterruptedException
	{
		driver.get(URL2);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String URL = js.executeScript("return document.URL").toString();
		System.out.println(URL);
		
		String title = js.executeScript("return document.title").toString();
		System.out.println(title);
		
		String domain = js.executeScript("return document.domain").toString();
		System.out.println(domain);
		
		js.executeScript("document.getElementById('txtUsername').value='Admin'");
		System.out.println("Username Added");
		
		Thread.sleep(3000);
	
		js.executeScript("document.getElementById('txtPassword').value='admin123'");
		System.out.println("Password Added");
		
		js.executeScript("document.getElementById('btnLogin').click();");
		
		//js.executeScript("document.getElementById('menu_pim_viewPimModule').click();");
		js.executeScript("return document.getElementById('menu_pim_viewPimModule')");
		js.executeScript("return document.getElementById('menu_pim_viewEmployeeList').click()");
		Thread.sleep(2000);
		
		//js.executeScript("window.scrollBy(0, 500)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		Thread.sleep(2000);
		js.executeScript("document.getElementById('ohrmList_chkSelectRecord_39').scrollIntoView()");
		
		//by driver
//		String table = driver.findElement(By.id("resultTable")).getText();
//		System.out.println(table);
		
		//
		String table1= js.executeScript("return document.getElementById('resultTable').innerText").toString();
		System.out.println(table1);
		
		String HTML= js.executeScript("return document.getElementById('resultTable').innerHTMl").toString();
		System.out.println(HTML);
		
	}


}



