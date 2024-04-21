package steps;

import org.aeonbits.owner.ConfigFactory;

public class ConfigGenerator {

    private static ConfigMapper uiConfig = null;

    public ConfigMapper getUIConfig(){
        String path = "src/test/resources/config";
        ConfigFactory.setProperty("mypath",path);
        uiConfig = ConfigFactory.create(ConfigMapper.class);
        return uiConfig;
    }
}
