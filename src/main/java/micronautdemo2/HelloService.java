package micronautdemo2;

import javax.inject.Inject;

public class HelloService {

    private HelloClient helloClient;

    @Inject
    public HelloService(HelloClient helloClient) {
        this.helloClient = helloClient;
    }

    public String getHello() {
        return helloClient.getResponse().getGreeting();
    }
}
