package org.assignment.utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {
    private static WebDriver driver;
    private static String browser = "chrome"; // Change to the desired browser

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (browser.toLowerCase()) {
                case "chrome":
                    // WebDriverManager.chromedriver().setup(); Comment out this line
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe"); // Specify the path
                    driver = new ChromeDriver();
                    break;
            }
        }
        return driver;
    }
}