package io.plucen.repositories.fakes;

import io.plucen.entities.Identifiable;
import io.plucen.repositories.CrudRepository;
import java.util.ArrayList;
import java.util.List;

public abstract class FakeCrudRepository<T extends Identifiable<ID>, ID>
    implements CrudRepository<T, ID> {

  private final List<T> entries = new ArrayList<>();

  @Override
  public List<T> index() {
    return List.copyOf(entries);
  }

  @Override
  public void save(T entry) {
    entries.add(entry);
  }
}
