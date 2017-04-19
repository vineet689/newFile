package demo;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class GoogleTitle {
	WebDriver driver = null; 
	@Test
	public void testJenkins(){
		 System.setProperty("webdriver.chrome.driver", "F://Data//ChromeDriver//chromedriver.exe");
		   driver = new ChromeDriver();
		String url= "http://google.com";
		driver.get(url);
		driver.manage().window().maximize();
		String expectedTitle= "Google";
		
		String actualTitle= driver.getTitle();
		System.out.println("Page title is: " +actualTitle);
		if(expectedTitle.equals(actualTitle)){
			System.out.println("Verification Sucessfull done----Title Macth");
		}
		else{
			System.out.println("There is some issue-----Title doesnt match");
     		}
		driver.close();
		
	
	}

}
