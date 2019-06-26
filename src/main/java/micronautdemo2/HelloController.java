package micronautdemo2;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller
public class HelloController {

    @Value("${micronaut.application.helloworld.name}")
    private String name;

    private String appPropertiesName;

    private HelloService helloService;

    public HelloController(AppConfigurationProperties appConfigurationProperties, HelloService helloService) {
        this.appPropertiesName = appConfigurationProperties.getName();
        this.helloService = helloService;
    }


    @Get("/hello")
    public String getName() {
        return "Hello, " + name + " " + appPropertiesName + helloService.getHello();
    }

    @Get("/helloresponse")
    public HelloResponse getHelloResponse() {
        HelloResponse helloResponse = new HelloResponse();
        helloResponse.setGreeting("hi");
        return helloResponse;

    }

}
