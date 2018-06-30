package testng_demo_class;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Home {

	static public WebDriver driver;
	List<String> links=new ArrayList();
	
	  @AfterSuite
	  public void closebrowser() {
		  driver.close();
	    System.out.println("AfterSuite");
	  }
	  
		@BeforeClass
		public void initialize()
		{ 
			driver=OnlineBanking.driver;
			  links.add("Checking Account Activity");
			  links.add("Transfer Funds");
			  links.add("My Money Map");
			  System.out.println("BeforeClass");
		}
		
		@Test (priority=3)
		  public void withoutsignin() {
			  for(String str:links)
			  {
				  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();
				  Assert.assertEquals(driver.getTitle(),"Zero - Log in");
				  driver.navigate().back();
			  }
			  System.out.println("withoutsignin");
			  }	  
		
		@Test (priority=4)
		  public void withsignin() {
				driver.findElement(By.id("signin_button")).click();
				driver.findElement(By.id("user_login")).sendKeys("username");
				driver.findElement(By.name("user_password")).sendKeys("password");
				driver.findElement(By.name("submit")).click();
				
				driver.findElement(By.xpath("//a[contains(text(),'Zero Bank')]")).click();
				
				 for(String str:links)
				  {
					  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();
					  Assert.assertEquals(true,(str.contains(driver.getTitle().substring(7))));
					  driver.navigate().back();
				  }
				
				driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a")).click();
				driver.findElement(By.id("logout_link")).click();
				    System.out.println("withsignin");
				  }
}
