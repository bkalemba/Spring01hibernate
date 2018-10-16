package pl.coderslab.beans;

import pl.coderslab.model.Publisher;

public interface PublisherServiceInterface {
    void save(Publisher entity);

    Publisher find(long id);

    void update(Publisher entity);

    void delete(long id);
}
