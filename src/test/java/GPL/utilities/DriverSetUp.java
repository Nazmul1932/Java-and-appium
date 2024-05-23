package GPL.utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverSetUp {

    public AppiumDriverLocalService service;
    private static final ThreadLocal<AndroidDriver> LOCAL_DRIVER = new ThreadLocal<>();
    public static void setDriver(AndroidDriver driver) {
        LOCAL_DRIVER.set(driver);
    }
    public static AndroidDriver getDriver() {return LOCAL_DRIVER.get();}
    @BeforeSuite
    public void driverSetUp() throws MalformedURLException{
        Map<String, String> env = new HashMap<String, String>(System.getenv());
        env.put("ANDROID_HOME", "C:\\Users\\BS971\\AppData\\Local\\Android\\Sdk");
        env.put("java-home", "C:\\Program Files\\Java\\jdk-19");

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\BS971\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).withTimeout(Duration.ofSeconds(500)).build();
        service.start();

        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
        uiAutomator2Options.setDeviceName("GPL");
        uiAutomator2Options.setPlatformName("Android");
        uiAutomator2Options.setApp(System.getProperty("user.dir") + "\\apps\\gpl-123.apk");

        AndroidDriver androidDriver = new AndroidDriver(new URL("http://127.0.0.1:4723"), uiAutomator2Options);
        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
        setDriver(androidDriver);
    }

    @AfterSuite
    public void quitDriver() {
        getDriver().quit();
        service.stop();
    }

}
