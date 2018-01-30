package steps;

import base.BaseUtil;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.Platform.WINDOWS;

public class Hook  {

    String url = "http://ssaha171717:fe1422df-d49f-4c68-a13b-1ca649149aa7@ondemand.saucelabs.com:80/wd/hub";

    String alwaysSameUrl = "http://USERNAME:ACCESSKEY@ondemand.saucelabs.com:80/wd/hub";

    private BaseUtil base;

    public Hook(BaseUtil base){
        this.base = base;
    }

    @Before
    public  void setUp(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        base.driver = new ChromeDriver();
        base.driver.manage().window().maximize();
       /*
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability("platform", "Windows 10");
        cap.setCapability("platform", "mac");

        try {
            base.driver = new RemoteWebDriver(new URL(url), cap);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        */
        base.driver.navigate().to("https://www.homedepot.com/");
    }
    @After
    public  void teadDown(){
    base.driver.quit();
    }

}
