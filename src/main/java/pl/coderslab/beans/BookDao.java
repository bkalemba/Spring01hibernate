package pl.coderslab.beans;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class BookDao implements BookDaoInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Book entity) {
        entityManager.persist(entity);
    }

    @Override
    public Book find(long id) {
        return entityManager.find(Book.class, id);
    }

    @Override
    public void update(Book entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(long id) {
        Book entity = this.find(id);
        entityManager.remove(entity);
    }

    public List<Book> loadAll(){
        Query query = entityManager.createQuery("SELECT b FROM Book b");
        return query.getResultList();
    }
}
