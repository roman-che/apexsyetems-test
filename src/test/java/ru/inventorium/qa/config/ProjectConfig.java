package ru.inventorium.qa.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties",
        "classpath:config/remote.properties"
})

public interface ProjectConfig extends Config {

    @DefaultValue("selenoid.autotests.cloud/wd/hub/")
    String remoteDriverUrl();

    @DefaultValue("https://selenoid.autotests.cloud/video/")
    String videoStorage();

    String login();

    String password();
}
