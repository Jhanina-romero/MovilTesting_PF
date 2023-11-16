package testAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BasicTest {
    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","Mi 9T");
        config.setCapability("platformVersion","11.0");
        config.setCapability("appPackage","com.miui.notes");
        config.setCapability("appActivity","com.miui.notes.ui.NotesListActivity");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
    }
    @Test
    public void verifySomething() throws InterruptedException {
        Thread.sleep(5000);
    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }
}
