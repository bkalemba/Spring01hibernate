package pl.coderslab.beans;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Book;
import pl.coderslab.model.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PublisherDao implements PublisherDaoInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Publisher entity) {
        entityManager.persist(entity);
    }

    @Override
    public Publisher find(long id) {
        return entityManager.find(Publisher.class, id);
    }

    @Override
    public void update(Publisher entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(long id) {
        Publisher entity = this.find(id);
        entityManager.remove(entity);
    }
}
