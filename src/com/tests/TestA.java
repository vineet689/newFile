package com.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by VINEET.
 */
public class TestA {
	
	public WebDriver driver;
	static String driverPath = "D://chromedriver";
	
	@Parameters({ "browserType", "appURL" })
	@BeforeClass
	public void initializeTestBaseSetup(String browserType, String appURL) {
		try {
			setDriver(browserType, appURL);

		} catch (Exception e) {
			System.out.println("Error....." + e.getStackTrace());
		}
	}
	
	private void setDriver(String browserType, String appURL) {
		switch (browserType) {
		case "chrome":
			driver = initChromeDriver(appURL);
			break;
		case "firefox":
			driver = initFirefoxDriver(appURL);
			break;
		default:
			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
			driver = initFirefoxDriver(appURL);
		}
	}

	private static WebDriver initChromeDriver(String appURL) {
		System.out.println("Launching google chrome with new profile..");
		System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	private static WebDriver initFirefoxDriver(String appURL) {
		System.out.println("Launching Firefox browser..");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to(appURL);
		return driver;
	}

	
    @Test
    public void firstTestCase() throws Exception {
        Thread.sleep(2000);
        System.out.println("im in first test case from ClassOne Class");
        
    }

    @Test
	public void secondTestCase() throws Exception {
		Thread.sleep(1000);
		System.out.println("im in second test case from ClassOne Class");

		//Below statement will throw exception
		WebElement ele = driver.findElement(By.id("test"));
		ele.click();
	}
    
    @Test
    public void thirdTestCase() throws Exception {
        Thread.sleep(2000);
        System.out.println("im in first test case from ClassOne Class");
    }
    
    @AfterClass
    public void tearDown() {
    	if(driver!=null) {
    		driver.quit();
    	}
    }

}