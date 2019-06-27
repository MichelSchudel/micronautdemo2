package micronautdemo2;

import java.util.List;

import io.micronaut.context.annotation.Value;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;

@Controller
public class BookController {

    @Value("${micronaut.application.helloworld.name}")
    private String name;

    private String appPropertiesName;

    private HelloService helloService;

    public BookController(AppConfigurationProperties appConfigurationProperties, HelloService helloService) {
        this.appPropertiesName = appConfigurationProperties.getName();
        this.helloService = helloService;
    }

    @Get("hello")
    public String hello() {
        return "Hello, " + appPropertiesName;
    }

    @Get("books")
    public List<BookStock> getBooks() {
        return helloService.getBooks();
    }

    @Get("stockresponse/{title}")
    public StockResponse getStockResponse(@PathVariable String title) {
        StockResponse stockResponse = new StockResponse();
        stockResponse.setBooksInStock(10);
        return stockResponse;

    }

}
