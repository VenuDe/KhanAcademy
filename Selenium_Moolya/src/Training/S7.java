package Training;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class S7 {


	String URL3 = "https://demoapp.skillrary.com/";
	WebDriver driver;
	
	
@BeforeTest
	public void BT()
	{
		driver = new ChromeDriver();
		
	
	
	}
	
@Test
	public void testcase1()
	{
		driver.get(URL3);
		driver.findElement(By.linkText("LOGIN")).click();
		driver.findElement(By.name("email")).sendKeys("user");
		driver.findElement(By.name("password")).sendKeys("user");
		driver.findElement(By.xpath("//*[@class=\"login_Btn\"]")).click();
		
		driver.findElement(By.xpath("//tbody/tr[2]/td[3]//preceding-sibling::td[2]/button")).click();
	}
}
