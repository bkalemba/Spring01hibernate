package pl.coderslab.beans;

import org.springframework.stereotype.Repository;
import pl.coderslab.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PersonDao implements PersonDaoInterface {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Person entity) {
        entityManager.persist(entity);
    }

    @Override
    public Person find(long id) {
        return entityManager.find(Person.class, id);
    }

    @Override
    public void update(Person entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(long id) {
        Person entity = this.find(id);
        entityManager.remove(entity);
    }
}
