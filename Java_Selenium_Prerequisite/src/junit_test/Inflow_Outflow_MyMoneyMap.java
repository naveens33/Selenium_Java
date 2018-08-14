package junit_test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;

public class Inflow_Outflow_MyMoneyMap {
	static String driverPath="D:\\Selenium Training\\chromedriver_win32(1)\\";
	static public WebDriver driver;

	@BeforeClass
	static public void openbrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		System.out.println("openbrowser");
	}
	
	@Before
	public void login()
	{
		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		
		System.out.println("login");
	}

	@After
	public void logout()
	{
		driver.findElement(By.xpath("//*[@id='settingsBox']/ul/li[3]/a")).click();
		driver.findElement(By.id("logout_link")).click();
		System.out.println("logout");
	}
	
	@AfterClass
	static public void closebrowser()
	{
		driver.close();
		System.out.println("closebrowser");
	}
	
	
	
	@Test
	public void inflow() {
		
		List<String> attribute = new ArrayList();
		attribute.add("Direct Deposits");
		attribute.add("Other Deposits");
		attribute.add("Transfers from other Zero Bank Accounts");
		
		List<String> value = new ArrayList();
		value.add("$0.00");
		value.add("$5,000.00");
		value.add("$1,150.00");
		
		driver.findElement(By.cssSelector("li#money_map_tab>a")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gridview-1015']/table/tbody/tr[4]/td[1]/div/b")));
		
		List<WebElement> tr=driver.findElements(By.xpath("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr"));
		for(int i=1;i<tr.size();i++)
		{
			
			WebElement att_ele = driver.findElement(By.xpath("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[1]"));
			WebElement val_ele=driver.findElement(By.xpath("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[2]"));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", att_ele);
			js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", val_ele);
			 
			//System.out.println("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[1]");
			String actualattr=att_ele.getText();
			String actualval=val_ele.getText();
			Assert.assertEquals(attribute.get(i-1),actualattr);
			Assert.assertEquals(value.get(i-1),actualval);
		}
		System.out.println("inflow");
	}

	//@Ignore
	@Test
	public void outflow() {
		List<String> attribute = new ArrayList();
		attribute.add("Transportation");
		attribute.add("Auto");
		
		List<String> value = new ArrayList();
		value.add("$160.00");
		value.add("$102.38");
		
		driver.findElement(By.cssSelector("li#money_map_tab>a")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gridview-1021']/table/tbody/tr[4]/td[1]/div/b")));
		
		List<WebElement> tr=driver.findElements(By.xpath("//tr[contains(@id,'bd-Spendings')]/td/table/tbody/tr"));
		for(int i=1;i<attribute.size();i++)
		{
			String att=driver.findElement(By.xpath("//tr[contains(@id,'bd-Spendings')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[1]")).getText();
			String val=driver.findElement(By.xpath("//tr[contains(@id,'bd-Spendings')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[2]")).getText();
			Assert.assertEquals(attribute.get(i-1),att);
			Assert.assertEquals(value.get(i-1),val);
		}
		System.out.println("outflow");
	}
}