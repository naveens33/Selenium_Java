package testng_snippet;

import org.testng.annotations.Test;

public class testcase5_ignore {
	@Test //default enable=true
	public void test1() {
		System.out.println("@Test - runTest1");
	}

	@Test(enabled = true)
	public void test2() {
		System.out.println("@Test - runTest2");
	}

	@Test(enabled = false)
	public void test3() {
		System.out.println("@Test - runTest3");
	}

}
