package testng_snippet;

import org.testng.annotations.Test;

public class testcase4_timeout {

	@Test(timeOut = 5000) // time in mulliseconds
	public void testThisShouldPass() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	@Test(timeOut = 3000)
	public void testThisShouldFail() throws InterruptedException {
		Thread.sleep(4000);
	}
}
