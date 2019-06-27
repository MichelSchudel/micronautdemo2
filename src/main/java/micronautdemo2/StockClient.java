package micronautdemo2;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.retry.annotation.CircuitBreaker;

@Client("http://localhost:8080/")
@CircuitBreaker(attempts = "2")
public interface StockClient {

    @Get("/stockresponse/{title}")
    StockResponse getResponse(String title);
}
