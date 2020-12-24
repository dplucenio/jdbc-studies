package io.plucen.repositories.sql;

import io.plucen.entities.Student;
import java.util.UUID;
import javax.sql.DataSource;

public class SqlStudentRepository extends SqlRepository<Student, UUID> {

  public SqlStudentRepository(DataSource dataSource) {
    super(dataSource);
  }
}
