package ru.sportmarafon.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import ru.sportmarafon.config.web.WebConfig;

import java.util.Objects;
import java.util.function.Supplier;

import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Browsers.FIREFOX;

public class WebDriverProvider implements Supplier<WebDriver> {

    private final WebConfig webConfig;

    public WebDriverProvider() {
        this.webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(webConfig.baseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (Objects.isNull(webConfig.remoteUrl())) {
            switch (webConfig.browser()) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    return new ChromeDriver();
                }
                case FIREFOX: {
                    WebDriverManager.firefoxdriver().setup();
                    return new FirefoxDriver();
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        } else {
            switch (webConfig.browser()) {
                case CHROME: {
                    return new RemoteWebDriver(webConfig.remoteUrl(), new ChromeOptions());
                }
                case FIREFOX: {
                    return new RemoteWebDriver(webConfig.remoteUrl(), new FirefoxOptions());
                }
                default: {
                    throw new RuntimeException("No such driver");
                }
            }
        }
    }
}