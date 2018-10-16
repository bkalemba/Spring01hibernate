package pl.coderslab.beans;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Author;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class AuthorDao implements AuthorDaoInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Author entity) {
        entityManager.persist(entity);
    }

    @Override
    public Author find(long id) {
        return entityManager.find(Author.class, id);
    }

    @Override
    public void update(Author entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(long id) {
        Author entity = this.find(id);
        entityManager.remove(entity);
    }
}
