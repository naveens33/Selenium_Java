package testng_snippet;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcase2_ann {


	@BeforeMethod
	public void beforeMethod() {
		System.out.println("----@BeforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		System.out.println("----@AfterMethod");
	}
	
	@Test(groups = "group1")
	public void runTest1() {
		System.out.println("-----@Test - runTest3");
	}

	@AfterSuite()
	public void afterSuite() {
		System.out.println("-@AfterSuite");
	}
	
}
