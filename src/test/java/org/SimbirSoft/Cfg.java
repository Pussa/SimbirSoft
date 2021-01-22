package org.SimbirSoft;
import org.aeonbits.owner.Config;

@Config.Sources({"file:./src/test/resources/cfg.properties"})
public interface Cfg extends Config {
    @Key("email")
    String email();
    @Key("password")
    String password();
    @Key("emailOfRecipient")
    String emailOfRecipient();
    @Key("website")
    String website();
    @Key("wayToDriver")
    String wayToDriver();
    @Key("chromeDriver")
    String chromeDriver();
    int waiting();
}
