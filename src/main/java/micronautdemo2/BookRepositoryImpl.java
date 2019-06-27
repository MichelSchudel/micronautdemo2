package micronautdemo2;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.micronaut.spring.tx.annotation.Transactional;

@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void dataLoader() {
        save(new Book("Lord of the rings"));
        save(new Book("The Hobbit"));
    }

    @Override
    public Optional<Book> findById(@NotNull final Long id) {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }

    @Override
    public Optional<Book> getByTitle(final String title) {
        return Optional.empty();
    }

    @Override
    public Book save(@NotNull final Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public void deleteById(@NotNull final Long id) {
        findById(id).ifPresent(book -> entityManager.remove(book));
    }

    @Override
    public List<Book> findAll() {
        String qlString = "SELECT b FROM Book as b";
        TypedQuery<Book> query = entityManager.createQuery(qlString, Book.class);
        return query.getResultList();
    }

    @Override
    public int update(@NotNull final Long id, @NotBlank final String title) {
        return entityManager.createQuery("UPDATE Book b SET title = :name where id = :id")
                .setParameter("title", title)
                .setParameter("id", id)
                .executeUpdate();
    }
}
