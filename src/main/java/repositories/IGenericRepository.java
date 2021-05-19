package repositories;

public interface IGenericRepository<T> {
    void add(T t);

    T update(T t);

    T delete(Integer id);

    T find(Integer id);

    Iterable<T> findAll();
}
