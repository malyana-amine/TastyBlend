package app.tasty.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    List<T> findAll();

    Optional<T> findById(ID id);

    T save(T entityDTO);

    T update(T entityDTO);

    Optional<T> delete(ID id);
}