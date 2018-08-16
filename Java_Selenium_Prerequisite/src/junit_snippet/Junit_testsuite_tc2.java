package junit_snippet;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assume;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Junit_testsuite_tc2 {

	@BeforeClass
	public static void bC() {
		System.out.println("-bC2");
	}
	
	@Before
	public void b() {
		System.out.println("--b2");
	}
	
	@Test
	public void tM1() {
		Assume.assumeTrue(System.getProperty("os.name").contains("Linux"));
		System.out.println("----TM2");
	}
	
	@Test
	public void tM2() {
		Assume.assumeFalse(System.getProperty("os.name").contains("Linux"));
		System.out.println("----TM2");
	}
	
	@After
	public void a() {
		System.out.println("--a2");
	}
	
	@AfterClass
	public static void aC() {
		System.out.println("-aC2");
	}
}
