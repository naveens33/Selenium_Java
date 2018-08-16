package junit_snippet;

import java.util.NoSuchElementException;

import org.junit.*;

public class Junit_anno_example {

	@BeforeClass
	public static void bC() {
		System.out.println("-bC");
	}
	
	@Before
	public void b() {
		System.out.println("--b");
	}
	
	@Test
	public void tM1() {
		System.out.println("----TM1");
	}
	
	@Test @Ignore 
	public void tM2() {
		System.out.println("----TM2");
	}
	
	@Test @Ignore("This test is disabled")
	public void tM3() {
		System.out.println("----TM3");
	}
	
	@Test (expected = NoSuchElementException.class)
	public void tM4() {
		System.out.println("----TM4");
		throw(new NoSuchElementException());
	}
	
	@Test (expected = NoSuchElementException.class)
	public void tM5() {
		System.out.println("----TM5");
	}
	
	@Test(timeout=100)
	public void tM6() throws InterruptedException {
		Thread.sleep(101);
		System.out.println("----TM6");
	}
	
	@After
	public void a() {
		System.out.println("--a");
	}
	
	@AfterClass
	public static void aC() {
		System.out.println("-aC");
	}

}
