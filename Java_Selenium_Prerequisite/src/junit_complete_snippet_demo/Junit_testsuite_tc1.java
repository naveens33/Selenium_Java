package junit_complete_snippet_demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;


public class Junit_testsuite_tc1 {

	  	
	
	@BeforeClass
	public static void bC() {
		System.out.println("-bC1");
	}
	
	@Before
	public void b() {
		System.out.println("--b1");
	}
	
	@Test
	public void tM1() {
		System.out.println("----TM1");
	}
	
	@After
	public void a() {
		System.out.println("--a1");
	}
	
	@AfterClass
	public static void aC() {
		System.out.println("-aC1");
	}
}
