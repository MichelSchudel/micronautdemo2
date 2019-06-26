package micronautdemo2;

import io.micronaut.context.annotation.ConfigurationProperties;

import javax.validation.constraints.NotBlank;

@ConfigurationProperties("appproperties")
public class AppConfigurationProperties {

    @NotBlank
    private String name;

    public String getName() {
        return name;

    }

    public void setName(String name) {
        this.name = name;
    }
}
