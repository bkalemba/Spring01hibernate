package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Author;

@Service
@Transactional
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    private AuthorDaoInterface dao;

    @Override
    public void save(Author entity) {
        dao.save(entity);
    }

    @Override
    public Author find(long id) {
        return dao.find(id);
    }

    @Override
    public void update(Author entity) {
        dao.update(entity);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
