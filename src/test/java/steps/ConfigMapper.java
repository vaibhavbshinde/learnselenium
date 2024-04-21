package steps;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"file:${mypath}/config.properties"})
public interface ConfigMapper extends Config{
    @Key("base.api.uri")
    String getBaseApiUri();

    @Key("user")
    String getUser();

    @Key("password")
    String getPassword();


}
