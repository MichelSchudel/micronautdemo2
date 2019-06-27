package micronautdemo2;

import io.micronaut.core.annotation.Introspected;

@Introspected
public class BookStock {

    public BookStock() {
    }

    private String title;

    private int stock;

    public BookStock(final String title, final int stock) {
        this.title = title;
        this.stock = stock;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(final int stock) {
        this.stock = stock;
    }
}
