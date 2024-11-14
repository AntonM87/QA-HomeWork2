package Helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "system:env",
        "file:src/main/resources/main.properties"
})

public interface HomeWorkProperties extends Config {
    @Config.Key("C:\\tmp\\chromedriver.exe")
    String chromeDriverOriginPath();

    @Config.Key("main.url")//main.url - это индефикатор этого параметра в файле main.properties
    String mainUrl();
}
