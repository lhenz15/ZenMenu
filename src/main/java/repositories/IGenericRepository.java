package repositories;

public interface IGenericRepository<E, K> {
    void add(E t);

    E update(E t);

    E delete(K id);

    E find(K id);

    Iterable<E> findAll();
}
