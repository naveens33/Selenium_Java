package selenium_grid_demo;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class Grid_demo1 {

    WebDriver driver;
    String baseURL, nodeURL;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = "http://192.168.0.105:44410/wd/hub";
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.WIN10);
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
    @Test
    public void sampleTest() {
        driver.get(baseURL);
        driver.get(baseURL);

        if (driver.getPageSource().contains("MOBILE TESTING")) {
            Assert.assertTrue(true, "Mobile Testing Link Found");
        } else {
            Assert.assertTrue(false, "Failed: Link not found");
        }

    }
    C:\Users\Wonder>java -jar selenium-server-standalone-2.44.0.jar -role hub
    Error: Unable to access jarfile selenium-server-standalone-2.44.0.jar

    C:\Users\Wonder>java -jar D:\Selenium\selenium-server-standalone-3.13.0.jar -role hub
    19:04:50.042 INFO [GridLauncherV3.launch] - Selenium build info: version: '3.13.0', revision: '2f0d292'
    19:04:50.057 INFO [GridLauncherV3$2.launch] - Launching Selenium Grid hub on port 4444
    2018-07-04 19:04:51.057:INFO::main: Logging initialized @3229ms to org.seleniumhq.jetty9.util.log.StdErrLog
    19:04:52.292 INFO [Hub.start] - Selenium Grid hub is up and running
    19:04:52.292 INFO [Hub.start] - Nodes should register to http://192.168.0.104:4444/grid/register/
    19:04:52.292 INFO [Hub.start] - Clients should connect to http://192.168.0.104:4444/wd/hub

}