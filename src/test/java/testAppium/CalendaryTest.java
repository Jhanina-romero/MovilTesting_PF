package testAppium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalendaryTest {
    AppiumDriver mobile;
    @BeforeEach
    public void openApp() throws MalformedURLException {
        DesiredCapabilities config = new DesiredCapabilities();
        config.setCapability("deviceName","Mi 9T");
        config.setCapability("platformVersion","11.0");
        config.setCapability("appPackage","com.xiaomi.calendar");
        config.setCapability("appActivity","com.android.calendar.homepage.AllInOneActivity");
        config.setCapability("platformName","Android");
        config.setCapability("automationName","uiautomator2");
        mobile = new AndroidDriver(new URL(" http://127.0.0.1:4723/wd/hub"),config);
        mobile.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    @Test
    public void verifyAddEvent() throws InterruptedException {
        String activity_Title = "Actividad de prueba movil";

        // click +  button
        mobile.findElement(By.id("com.xiaomi.calendar:id/new_event")).click();
        // Escribir el titulo
        mobile.findElement(By.id("com.xiaomi.calendar:id/title")).sendKeys(activity_Title);
        // Habilitar repetir todo el dia
        mobile.findElement(By.id("com.xiaomi.calendar:id/all_day_row")).click();
        // Guardar
        mobile.findElement(By.id("com.xiaomi.calendar:id/action_done")).click();

        Thread.sleep(5000);
        // verificacion  expected vs actual

        Assertions.assertTrue(mobile.findElements(By.xpath("//android.widget.TextView[@resource-id=\"com.xiaomi.calendar:id/primary\" and @text=\""+ activity_Title + "\"]")).size() == 1,
                "ERROR>>> la tarea no fue creada" );
    }

    @AfterEach
    public void closeApp(){
        mobile.quit();
    }
}
