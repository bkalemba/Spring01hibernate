package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Person;

@Service
@Transactional
public class PersonService implements PersonServiceInterface {

    @Autowired
    private PersonDaoInterface dao;

    @Override
    public void save(Person entity) {
        dao.save(entity);
    }

    @Override
    public Person find(long id) {
        return dao.find(id);
    }

    @Override
    public void update(Person entity) {
        dao.update(entity);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
