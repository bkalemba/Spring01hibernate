package pl.coderslab.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.model.Publisher;

@Service
@Transactional
public class PublisherService implements PublisherServiceInterface {

    @Autowired
    private PublisherDaoInterface dao;

    @Override
    public void save(Publisher entity) {
        dao.save(entity);
    }

    @Override
    public Publisher find(long id) {
        return dao.find(id);
    }

    @Override
    public void update(Publisher entity) {
        dao.update(entity);
    }

    @Override
    public void delete(long id) {
        dao.delete(id);
    }
}
