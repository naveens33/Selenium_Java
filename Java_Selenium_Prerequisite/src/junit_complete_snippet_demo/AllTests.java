package junit_complete_snippet_demo;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ Junit_para_example.class })
public class AllTests {

}

