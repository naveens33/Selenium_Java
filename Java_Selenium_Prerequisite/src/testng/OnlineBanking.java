package testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Ignore;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineBanking {

	static String driverPath="D:\\Selenium\\chromedriver_win32\\";
	static public WebDriver driver;
	List <String> link=new ArrayList();
	
	@BeforeSuite
	static public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void navigateto()
	{
		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		  link.add("Account Summary");
		  link.add("Account Activity");
		  link.add("Transfer Funds");
		  link.add("Pay Bills");
		  link.add("My Money Map");
		  link.add("Online Statements");
	}
	
	@Ignore	
  @Test (priority=1)
  public void beforelogin() {
	  driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).click();
	  
	  for(String str:link)
	  {
		  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();  
		  Assert.assertEquals(driver.getTitle(),"Zero - Log in" );
		  driver.navigate().back();
	  }
	  
	  driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
	  Assert.assertEquals("Zero - Log in", driver.getTitle());
  }
  
	@Ignore	
  @Test (priority=2)
  public void afterlogin() {
   	    driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Zero Bank')]")).click();
		  
		driver.findElement(By.xpath("//strong[contains(text(),'Online Banking')]")).click();
		  for(String str:link)
		  {
			  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();  
			  Assert.assertEquals("Zero - "+str, driver.getTitle());
			  driver.navigate().back();
		  }
		  //Assert.assertEquals(false, driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).isDisplayed());
	  	
		driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a")).click();
		driver.findElement(By.id("logout_link")).click();
		Assert.assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");
  }
}
