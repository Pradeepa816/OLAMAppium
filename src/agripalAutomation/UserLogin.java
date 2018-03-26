package agripalAutomation;

import io.appium.java_client.android.AndroidDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class UserLogin {

	AndroidDriver driver;

	@BeforeTest
	public void setUp() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ZY32299WHC");
		capabilities.setCapability(CapabilityType.VERSION, "7.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("autoGrantPermissions","true");
		capabilities.setCapability("appPackage", "com.olam.gabon");
		capabilities.setCapability("appActivity","com.olam.gabon.ui.SplashActivity");
		//capabilities.setCapability("fastReset", "true");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@Test
	public void login() {
			
			driver.findElement(By.xpath(("//android.widget.EditText[@text='019']"))).click();
			driver.getKeyboard().pressKey("000026");
			driver.pressKeyCode(66);
			String password = "Avenger.123#";
			password = password.substring(0 ,1).toUpperCase() + password.substring(1);
			driver.findElement(By.id("com.olam.gabon:id/et_input_pwd"));
			driver.getKeyboard().sendKeys(password);
			driver.pressKeyCode(66);			
			driver.findElement(By.xpath(("//android.widget.Button[@text='LOGIN']"))).click();
			
			driver.findElement(By.id("com.olam.gabon:id/rl_leftContainer")).click();
			List<WebElement> ga = driver.findElements(By.id("com.olam.gabon:id/tvName"));
			for(WebElement e : ga){
				System.out.println(e.getText());
			}
			
			ga.get(0).click();
			driver.findElement(By.xpath("//android.widget.TextView[@text='02-Mouila']")).click();
			ga.get(2).click();
			driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='02']")).click();
			ga.get(3).click();
			driver.findElement(By.xpath("//android:id/text1[@index='2']")).click();
			ga.get(4);
			
			
			
			
			
			
			
		//HarvestData();
	}
	

	@AfterTest
	public void afterTest() {
		//driver.resetApp();
		driver.quit();
	}
	
	/**public void HarvestData(){
		
		driver.findElement(By.id("com.olam.gabon:id/rl_leftContainer")).click();
		List<WebElement> ga = driver.findElements(By.id("com.olam.gabon:id/tvName"));
		for(WebElement e : ga){
			System.out.println(e.getText());
		}
		
				
}**/
	

}
