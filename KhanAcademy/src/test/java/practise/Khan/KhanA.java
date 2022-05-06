package practise.Khan;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.tools.ant.types.resources.comparators.Reverse;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.offset.PointOption;


public class KhanA extends cap3{
	
	ExtentReports extent;
	ExtentTest logger;
	 
	@BeforeTest
	public void killAllProcess() throws IOException, InterruptedException
	{
		//i am ensuring before any of my test starts if the appium server is up and running
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Thread.sleep(5000);
		service = startServer();
		extent = new ExtentReports(System.getProperty("user.dir")+"//Test_Output//Venu.html",true);
		extent.loadConfig(new File (System.getProperty("user.dir")+"//src//main//resources//extent-config.xml"));
	}
	
	
	
	@Test(priority = 0)
	public void tc0() throws InterruptedException, IOException
	{
		logger = extent.startTest("KhanAcademy");
		//This is starting my appium server
		
		//what is the benifit of using implicity wait
		AndroidDriver<AndroidElement> driver = HybridCapability(apppackage, appactivity, platformName, deviceName, chromeexcutable);
		//is to implement implicitwait 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
			logger.log(LogStatus.PASS, "Mobile App Opened");
			driver.findElementByAccessibilityId("Search tab").click();
			logger.log(LogStatus.PASS, "Clicked on Search button");
			Thread.sleep(3000);
//			driver.findElementByClassName("android.widget.TextView").click();
			driver.findElementByAndroidUIAutomator("text(\"Surprise me!\")").click();
			logger.log(LogStatus.PASS, "Clicked on Surprise me! link");
//			Thread.sleep(5000);
			
//			driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Pause\"]/android.widget.ImageView").click();
//			Thread.sleep(3000);
			
			TouchAction action = new TouchAction(driver);
			
	        Thread.sleep(2000);
	        action.tap(PointOption.point(537, 362)).perform();
	        logger.log(LogStatus.PASS, "Video started");
	        TouchAction action2 = new TouchAction(driver);
	        action2.tap(PointOption.point(537, 362)).perform();
	        logger.log(LogStatus.PASS, "Video paused");

//	       
	        driver.findElementByAccessibilityId("Explore tab").click();
	        logger.log(LogStatus.PASS, "Clicked on Home button");
	        WebElement Name = driver.findElementsByClassName("android.widget.TextView").get(6); 
	        
	        String Cn = Name.getAttribute("text");
//	        System.out.println(Cn );
	        Reporter.log("Surprice Course : "+Cn,true);
	        logger.log(LogStatus.PASS, "Got the played video title");
	        extent.endTest(logger);
			extent.close();
	        
		
		
	}
	@Test(enabled = false ,priority = 1)
    public void tc1() throws InterruptedException, IOException{
        
        //what is the benifit of using implicity wait
        AndroidDriver<AndroidElement> driver = HybridCapability(apppackage, appactivity, deviceName, platformName,chromeexcutable);
        //is to implement implicitwait 
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        Thread.sleep(10000);
        driver.findElement(By.xpath("//android.widget.ImageView[@content-desc=\"Settings\"]")).click();
        //driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Privacy policy\"))").click();
        driver.findElementByAndroidUIAutomator("UiSelector().text(\"Privacy policy\")").click();
        Thread.sleep(10000);
        
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        driver.context("WEBVIEW_chrome");
        JavascriptExecutor js= (JavascriptExecutor)driver;
        Thread.sleep(3000);
        
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        Thread.sleep(3000);
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        
    }
}





