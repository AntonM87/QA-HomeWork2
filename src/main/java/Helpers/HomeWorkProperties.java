package Helpers;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
                "system:properties" +
                "system:env" +
                "file:src/mail/resources/HomeWork.properties"
})

public interface HomeWorkProperties extends Config {
    @Config.Key("C:\\tmp\\chromedriver.exe")
    String ChomeDriverOriginPath();
}
