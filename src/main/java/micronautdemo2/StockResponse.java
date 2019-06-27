package micronautdemo2;

public class StockResponse {

    public StockResponse(final int booksInStock) {
        this.booksInStock = booksInStock;
    }

    public StockResponse() {
    }

    int booksInStock;

    public int getBooksInStock() {
        return booksInStock;
    }

    public void setBooksInStock(final int booksInStock) {
        this.booksInStock = booksInStock;
    }
}
