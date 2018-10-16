package pl.coderslab.beans;

import pl.coderslab.model.Author;

public interface AuthorServiceInterface {
    void save(Author entity);

    Author find(long id);

    void update(Author entity);

    void delete(long id);
}
