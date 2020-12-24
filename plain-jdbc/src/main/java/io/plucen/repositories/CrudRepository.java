package io.plucen.repositories;

import io.plucen.entities.Identifiable;
import java.util.List;
import java.util.Optional;

public interface CrudRepository<T extends Identifiable<ID>, ID> {

  List<T> index();

  void save(T entry);

  Optional<T> findById(ID id);
}
