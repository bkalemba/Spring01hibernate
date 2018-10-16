package pl.coderslab.beans;

import pl.coderslab.model.Person;

public interface PersonServiceInterface {
    void save(Person entity);

    Person find(long id);

    void update(Person entity);

    void delete(long id);
}
