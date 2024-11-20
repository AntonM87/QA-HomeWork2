package helpers;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"system:properties",
        "system:env",
        "file:src/main/resources/main.properties"
})

public interface HomeWorkProperties extends Config {

    public HomeWorkProperties homeWorkProperties = ConfigFactory.create(HomeWorkProperties.class);

    @Config.Key("main.url")//main.url - это индефикатор этого параметра в файле main.properties
    String mainUrl();

    @Config.Key("timeOutsSeconds")
    Integer timeOutsSeconds();

    @Config.Key("chromeDriverOrigin")
    String chromeDriverOrigin();

}
