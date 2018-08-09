package junit_complete_snippet_demo;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class Junit_para_example {

	private String m1;
	private String m2;
	
    public Junit_para_example(String p1, String p2) {
        m1 = p1;
        m2 = p2;
    }

    // creates the test data
    @Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][] { { "Transportation" ,"auto" } };
        return Arrays.asList(data);
    }
    
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
		System.out.println("----TM parameter1: "+m1+" parameter2: "+m2);
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
