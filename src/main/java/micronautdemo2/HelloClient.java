package micronautdemo2;

import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;

@Client("http://localhost:8080/helloresponse")
//@CircuitBreaker(attempts = "2")
public interface HelloClient {
    HelloResponse getResponse();
}
