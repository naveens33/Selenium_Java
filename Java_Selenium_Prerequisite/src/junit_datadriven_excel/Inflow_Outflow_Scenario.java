package junit_datadriven_excel;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class Inflow_Outflow_Scenario {
	static String driverPath="D:\\Selenium\\chromedriver_win32\\";
	static public WebDriver driver;
	static ReadExcelFile obj;
	@BeforeClass
	static public void openbrowser() throws Exception
	{
		obj=new ReadExcelFile();
		System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Before
	public void login()
	{
		driver.navigate().to("http://zero.webappsecurity.com/index.html");
		driver.findElement(By.xpath(Repository.getlocator("index","signin"))).click();
		driver.findElement(By.xpath(Repository.getlocator("login","username"))).sendKeys("username");
		driver.findElement(By.xpath(Repository.getlocator("login","password"))).sendKeys("password");
		driver.findElement(By.xpath(Repository.getlocator("login","signin"))).click();
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
	public void inflow(){
		
		driver.findElement(By.cssSelector("li#money_map_tab>a")).click();
		
		WebDriverWait wait=new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='gridview-1015']/table/tbody/tr[4]/td[1]/div/b")));
		
		List<WebElement> tr=driver.findElements(By.xpath("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr"));
		for(int i=1;i<tr.size();i++)
		{
			String att=driver.findElement(By.xpath("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[1]")).getText();
			String val=driver.findElement(By.xpath("//tr[contains(@id,'bd-Deposits')]/td/table/tbody/tr[contains(@class,'x-grid-row')]["+i+"]/td[2]")).getText();
			Assert.assertEquals(obj.inflowattribute.get(i-1),att);
			Assert.assertEquals(obj.inflowvalue.get(i-1),val);
		}
		System.out.println("inflow");
	}

	@Ignore
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
