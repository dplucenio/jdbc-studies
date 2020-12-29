package io.plucen.repositories;

import io.plucen.entities.Identifiable;
import java.util.List;

public interface CrudRepository<T extends Identifiable<ID>, ID> {

  List<T> index();

  void save(T entry);
}
