package Training;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class S8 {
	String URL = "https://demoqa.com/upload-download";
	String URL1 = "https://demoqa.com/webtables";
	String URL2 = "https://demoqa.com/frames";
	String URL3 = "https://demoqa.com/droppable";
	WebDriver driver;
	JavascriptExecutor js;
	
@BeforeTest 
	 
	public void BT()
	{
		driver = new ChromeDriver();
	
	}

@Test (enabled = false)
	public void testcase2()
	{
		driver.get(URL1);
		WebElement root = driver.findElement(By.xpath("//*[@class=\"rt-tr -odd\"]//following-sibling :: div[2]"));
		System.out.println(root.getText());
	}

@Test (enabled = false)
 	public void testcase1()
 	{
		driver.get(URL);
		driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\user\\Desktop\\TestCase.xlsx");
 	}

@Test (enabled = false)
	public void testcase3() throws InterruptedException
	{
		js = (JavascriptExecutor)driver;
		driver.get(URL2);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> frames = driver.findElements(By.tagName("iframe"));
		System.out.println(frames.size());
		
		for(int i=0; i<frames.size(); i++)
		{
			String name = frames.get(i).getAttribute("id");
			System.out.println(name);
		}
		driver.switchTo().frame("frame1");
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
		String Text = driver.findElement(By.id("sampleHeading")).getText();
		System.out.println(Text);
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		
		// going to frame 2
		driver.switchTo().frame("frame2");
		
		//scrolling using js executor
		
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		
	}

@Test
	public void testcase4() 
	{
		driver.get(URL3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act = new Actions(driver);
		
	
	WebElement drag = driver.findElement(By.id("draggable"));
	WebElement drop = driver.findElement(By.id("droppable"));
	
	//act.dragAndDrop(drag, drop).build().perform();
	
	
	act.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
	}

}
