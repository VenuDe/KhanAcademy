package Training;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class S4 {
	WebDriver driver;


	String URL = "https://demo.guru99.com/test/newtours/index.php";;

@BeforeTest

	public void BT() 
	{
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		
		
		
		
	}

@Test
	public void Testcase1() throws NoSuchElementException
	{
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println(link.size());
		
		for (int i=0; i<link.size();i++)
		{
			String a = link.get(i).getText();
			if (i<link.size())
			{
				driver.findElement(By.linkText(a)).click();
				
				driver.findElement(By.xpath("//*[contains(text(),'any inconvienece')]"));
				System.out.println(link.get(i).getText()+" : Link is not Working");
			}
			else
			{
				System.out.println("Link Working");
			}
		}
			
	}
	
}

