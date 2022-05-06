package Training;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class S3 {
public static void main(String[] args) throws InterruptedException 
{
		String homePage = "https://demo.guru99.com/test/newtours/";
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(homePage);
//		driver.navigate().to("https://demo.guru99.com/test/newtours/index.php");
//		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("prabh4747");
//		driver.findElement(By.xpath("//*[@name='password']")).sendKeys("prabh4747");
//		driver.findElement(By.xpath("//*[@name='submit']")).click();
//		Thread.sleep(2000);
		List<WebElement> links =driver.findElements(By.tagName("a"));
		System.out.println(links.size());
		Iterator<WebElement> it = links.iterator();
		for (int i =0;i<links.size();i++)
//			{
//				System.out.println(link.get(i).getText());
//			}
		while(it.hasNext())
		{
			url = it.next().getAttribute("href");
			System.out.println(url);
			if(url == null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			continue;
		}
			if(!url.startsWith(homePage))
			{
				System.out.println("URL belongs to another domain, skipping it.");
				continue;
			}
			try 
			{
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if(respCode >= 400)
				{
					System.out.println(url+" is broken");
				}
			else
			{
				System.out.println(url+" is a valid link");
			}
			}
			 catch (MalformedURLException e) 
			 {
				e.printStackTrace();
			 } 
			 catch (IOException e) 
			 {
				e.printStackTrace();
			 }
			}
		
			driver.quit();
 }
}
