package micronautdemo2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.micronaut.test.annotation.MicronautTest;
import io.micronaut.test.annotation.MockBean;

@MicronautTest
public class BooksIT {

    @Inject
    private BookController bookController;

    @Test
    public void testBooks() {
        assertThat(bookController.getBooks()).hasSize(2);
    }

    @MockBean(StockClient.class)                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        StockClient stockClient() {
        StockClient stockClient = mock(StockClient.class);
        when(stockClient.getResponse(isA(String.class))).thenReturn(new StockResponse(10));
        return stockClient;
    }
}
