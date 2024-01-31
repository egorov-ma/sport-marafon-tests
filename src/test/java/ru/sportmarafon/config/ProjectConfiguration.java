package ru.sportmarafon.config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.sportmarafon.config.web.WebConfig;

import java.util.Arrays;
import java.util.Map;

public class ProjectConfiguration {
    private final WebConfig webConfig;

    public ProjectConfiguration(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void webConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browser = webConfig.browser().toString();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        Configuration.baseUrl = webConfig.baseUrl();
        if (webConfig.isRemote()) {
            Configuration.remote = String.valueOf(webConfig.remoteUrl());
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "env", Arrays.asList("LANG=ru_RU.UTF-8", "LANGUAGE=ru:ru", "LC_ALL=ru_RU.UTF=8")
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}