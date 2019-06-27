package micronautdemo2;

import java.util.List;
import java.util.Optional;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface BookRepository {

    Optional<Book> findById(@NotNull Long id);

    Optional<Book> getByTitle(String title);

    Book save(@NotNull Book book);

    void deleteById(@NotNull Long id);

    List<Book> findAll();

    int update(@NotNull Long id, @NotBlank String name);
}
