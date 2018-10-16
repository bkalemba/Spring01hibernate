package pl.coderslab.beans;

import pl.coderslab.model.Book;

import java.util.List;

public interface BookDaoInterface {
    void save(Book entity);

    Book find(long id);

    void update(Book entity);

    void delete(long id);

    List<Book> loadAll();
}
