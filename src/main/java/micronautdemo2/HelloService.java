package micronautdemo2;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

public class HelloService {

    private StockClient stockClient;

    private BookRepository bookRepository;

    @Inject
    public HelloService(final StockClient stockClient, final BookRepository bookRepository) {
        this.stockClient = stockClient;
        this.bookRepository = bookRepository;
    }

    public List<BookStock> getBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> new BookStock(book.getTitle(), stockClient.getResponse(book.getTitle())
                        .getBooksInStock()))
                .collect(Collectors.toList());
    }

}
