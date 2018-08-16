package testng_snippet;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class testcase1_ann {

	@BeforeSuite()
	public void beforeSuite() {
		System.out.println("-@BeforeSuite");
	}

	@BeforeGroups("group1")
	public void beforeGroups() {
		System.out.println("---@BeforeGroups");
	}

	@AfterGroups("group1")
	public void afterGroups() {
		System.out.println("---@AfterGroups");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("--@BeforeClass");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("--@AfterClass");
	}

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
		System.out.println("-----@Test - runTest1");
	}

	@Test
	public void runTest4() {
		System.out.println("-----@Test - runTest4");
	}
	
	@Test
	public void runTest2() {
		System.out.println("-----@Test - runTest2");
	}

}
