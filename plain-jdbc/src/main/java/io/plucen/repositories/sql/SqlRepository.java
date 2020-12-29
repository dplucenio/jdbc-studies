package io.plucen.repositories.sql;

import io.plucen.entities.Identifiable;
import io.plucen.repositories.CrudRepository;
import java.util.List;
import javax.sql.DataSource;

public abstract class SqlRepository<T extends Identifiable<ID>, ID>
    implements CrudRepository<T, ID> {

  protected final DataSource dataSource;

  public SqlRepository(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Override
  public abstract List<T> index();

  @Override
  public abstract void save(T entry);
}
