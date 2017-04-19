package sslHandelling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SSL_Chrome {
	private WebDriver driver;

	@BeforeTest
	public void setUp() {
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		// To Accept SSL certificate
		capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		// setting system property for Chrome browser
		System.setProperty("webdriver.chrome.driver", "F://Data//ChromeDriver//chromedriver.exe");
		// create Google Chrome instance and maximize it
		driver = new ChromeDriver(capability);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		
		
	}

	@Test
	public void openApplication() {
		System.out.println("Navigating application");
		driver.get("https://cacert.org/");
		WebElement headingEle = driver.findElement(By.cssSelector(".story h3"));
		// Validate heading after accepting untrusted connection
		String expectedHeading = "Are you new to CAcert?";
		Assert.assertEquals(headingEle.getText(), expectedHeading);
		driver.findElement(By.id("xtt"));
	}

	@AfterTest
	public void tearDown() {
		if (driver != null)
			driver.quit();
	}
}

