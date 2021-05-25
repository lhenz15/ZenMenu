package repositories;

import java.util.Collection;

public interface IGenericRepository<E, K> {
    void add(E t);

    E update(E t);

    E delete(K id);

    E find(K id);

    Collection<E> findAll();
}
