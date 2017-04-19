package binary;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BinaryWeb {
	
	WebDriver driver= null;
	//private By getColor = By.xpath("//div[@id='comp-j0jg24n3']/h1[2]/span/span/span");
	Properties prop;
	
	@BeforeTest
	public void Getwindow(){
		System.setProperty("webdriver.chrome.driver", "F://Data//ChromeDriver//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		prop = new Properties();
		try{
			prop.load(new FileInputStream("or.Config"));
			System.out.println("Reading config files..........");
		}catch(Exception e){
			System.out.println("unable to read config file, some error occured....");
		}
	}
		
		@Test(priority=0)
		public void tesLink(){
			String Url= prop.getProperty("baseUrl");
			driver.get(Url);
		
		}
		
		@Test(priority = 1)
		public void getCSSValues(){
			String textColor=driver.findElement(By.xpath("//div[@id='comp-j0jg24n3']/h1[2]/span/span/span")).getCssValue("color");
			String font=driver.findElement(By.xpath("//div[@id='comp-j0jg24n3']/h1[2]/span/span/span")).getCssValue("font-size");
			String fontBold=driver.findElement(By.xpath("//div[@id='comp-j0jg24n3']/h1[2]/span/span/span")).getCssValue("font-weight");
			
		   // WebElement getColorsofText= driver.findElement(getColor);
		  //  System.out.println("Text color is : " +getColorsofText.getCssValue("color"));
			  System.out.println("Text color is : " +textColor);
			  System.out.println("Text Font is : " +font);
			  System.out.println("Text font bold? : " +fontBold);
		}
		
		@Test(priority = 2)
		public void getCokkies(){
			Cookie  cookie = new Cookie("mycookie", "123456789123");
			driver.manage().addCookie(cookie);
			Set<Cookie> cookieList = driver.manage().getCookies();
			for(Cookie getCokkies :cookieList){
				System.out.println("Cookes NAme to be: " +getCokkies);
			}
		}
		
		
		
		@Test(priority=3)
		public void verfy(){
			try {
			      assertTrue(isElementPresent(By.id("DrpDwnMn02label")));
			      driver.findElement(By.id("DrpDwnMn02label")).click();
			    } catch (Error e) {
			    	System.out.println("Account Elemnt not found");
			    }
		   // driver.findElement(By.id("comp-j10neofx_BasicPostsView_i6fey5qh445_dup_i6kjyhh3391_dup_i6qm3p3i327_dup_i708d4e41_dup_i70h8y9r207_dup_i7g7dwie319_j10neoh4_BasicPosts_i6fey5qh444_1__0_0_0_0_fld_i70kujk51028_proxylabel")).click();
		    WebElement searchOpenAccount= driver.findElement(By.id("comp-j10neofx_BasicPostsView_i6fey5qh445_dup_i6kjyhh3391_dup_i6qm3p3i327_dup_i708d4e41_dup_i70h8y9r207_dup_i7g7dwie319_j10neoh4_BasicPosts_i6fey5qh444_1__0_0_0_0_fld_i70kujk51028_proxylabel"));
			if(searchOpenAccount.isDisplayed()){
				System.out.println("Website open successfully!!");
				driver.findElement(By.id("comp-j10neofx_BasicPostsView_i6fey5qh445_dup_i6kjyhh3391_dup_i6qm3p3i327_dup_i708d4e41_dup_i70h8y9r207_dup_i7g7dwie319_j10neoh4_BasicPosts_i6fey5qh444_1__0_0_0_0_fld_i70kujk51028_proxylabel")).click();
			}
			else{
				System.out.println("We face an issue :( ");
			}
			}
		
		@Test(priority=4)
		public void moveToSecondWindow(){
			System.out.println("Finding data");
			}
		
		@AfterTest
		public void closeBrowser(){
			driver.close();
		}
		
		 private boolean isElementPresent(By by) {
			    try {
			      driver.findElement(by);
			      return true;
			    } catch (NoSuchElementException e) {
			      return false;
			    }
			  }

		
		
	}
	
	
	//https://www.binarycopy.com
	
