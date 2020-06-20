package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
    public enum Browser {
        Firefox,
        Chrome
    }

    public static WebDriver getWebDriver(Browser browser) {
        String osName = System.getProperty("os.name");
        String driverPath = System.getProperty("user.dir") + "/src/test/resources/drivers/";
        switch (browser) {
            case Chrome:
                if (osName.startsWith("Windows"))
                    System.setProperty("webdriver.chrome.driver", driverPath + "windows/chromedriver.exe");
                else if (osName.startsWith("Mac"))
                    System.setProperty("webdriver.chrome.driver", driverPath + "mac/chromedriver");
                else if (osName.startsWith("Linux"))
                    System.setProperty("webdriver.chrome.driver", driverPath + "linux/chromedriver");
                else
                    return null;
                return new ChromeDriver();
            case Firefox:
                if (osName.startsWith("Windows"))
                    System.setProperty("webdriver.gecko.driver", driverPath + "windows/geckodriver.exe");
                else if (osName.startsWith("Mac"))
                    System.setProperty("webdriver.gecko.driver", driverPath + "mac/geckodriver");
                else if (osName.startsWith("Linux"))
                    System.setProperty("webdriver.gecko.driver", driverPath + "linux/geckodriver");
                else
                    return null;
                return new FirefoxDriver();
        }
        return null;
    }
}