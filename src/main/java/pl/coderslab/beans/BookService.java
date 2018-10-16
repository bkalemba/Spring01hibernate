package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Book;

import java.util.List;

@Service
@Transactional
public class BookService implements BookServiceInterface {

    @Autowired
    private BookDaoInterface dao;

    @Override
    public void save(Book entity) {
        dao.save(entity);
    }

    @Override
    public Book find(long id) {
        return dao.find(id);
    }

    @Override
    public void update(Book entity) {
        dao.update(entity);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }

    public List<Book> loadAll(){
        return dao.loadAll();
    }
}
