package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;

public class Home {

	static public WebDriver driver;
	List <String> link=new ArrayList();
	
  @BeforeMethod
  public void beforeMethod() {
	  driver=OnlineBanking.driver;

		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		  link.add("Checking Account Activity");
		  link.add("Transfer Funds");
		  link.add("My Money Map");  
  }
	@AfterSuite
	static public void closebrowser() throws Exception
	{
		//GenerateReport.funGenerateReport();
		driver.close();
	}
	@Ignore
	  @Test (priority=3)
	  public void beforelogin() {
		  //driver.findElement(By.xpath("//strong[contains(text(),'Home')]")).click();
		  
		  for(String str:link)
		  {
			  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();  
			  Assert.assertEquals(driver.getTitle(),"Zero - Log in" );
			  driver.navigate().back();
		  }
	  }
	  
	  @Test (priority=4)
	  public void afterlogin() {
	   	    driver.findElement(By.id("signin_button")).click();
			driver.findElement(By.id("user_login")).sendKeys("username");
			driver.findElement(By.name("user_password")).sendKeys("password");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Zero Bank')]")).click();
			  
			driver.findElement(By.xpath("//strong[contains(text(),'Home')]")).click();
			  for(String str:link)
			  {
				  driver.findElement(By.xpath("//span[contains(text(),'"+str+"')]")).click();  
				  //System.out.println("driver.getTitle(): "+driver.getTitle().substring(7)+"\n"+"str: "+str+"\n"+"driver.getTitle().contains(str)"+driver.getTitle().contains(str));
				  Assert.assertEquals((str.contains(driver.getTitle().substring(7))),true);
				  driver.navigate().back();
			  }
			  //Assert.assertEquals(false, driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).isDisplayed());
		  	
			driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a")).click();
			driver.findElement(By.id("logout_link")).click();
			Assert.assertEquals(driver.getTitle(), "Zero - Personal Banking - Loans - Credit Cards");
	  }

}
