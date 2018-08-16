package testng_snippet;

import java.util.NoSuchElementException;

import org.testng.annotations.Test;

public class testcase3_dependency {

	@Test
	public void method1() {
		System.out.println("This is method 1");
		throw new NoSuchElementException();
	}

	@Test(dependsOnMethods = { "method1" })
	public void method2() {
		System.out.println("This is method 2");
	}
	
}
