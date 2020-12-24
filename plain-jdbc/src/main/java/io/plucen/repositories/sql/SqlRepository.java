package io.plucen.repositories.sql;

import io.plucen.entities.Identifiable;
import io.plucen.repositories.CrudRepository;
import java.util.List;
import java.util.Optional;
import javax.sql.DataSource;

public abstract class SqlRepository<T extends Identifiable<ID>, ID>
    implements CrudRepository<T, ID> {

  private final DataSource dataSource;

  public SqlRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public List<T> index() {
    return null;
  }

  @Override
  public void save(T entry) {}

  @Override
  public Optional<T> findById(ID id) {
    return Optional.empty();
  }
}
