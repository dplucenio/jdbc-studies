package io.plucen.repositories.sql;

import io.plucen.entities.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import javax.sql.DataSource;

public class SqlStudentRepository extends SqlRepository<Student, UUID> {

  public SqlStudentRepository(DataSource dataSource) {
    super(dataSource);
  }

  @Override
  public List<Student> index() {
    List<Student> students = new ArrayList<>();

    try (Connection connection = dataSource.getConnection()) {
      final ResultSet resultSet =
          connection.prepareStatement("SELECT * FROM student;").executeQuery();
      while (resultSet.next()) {
        students.add(new Student((UUID) resultSet.getObject(1), resultSet.getString(2)));
      }
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
    return students;
  }

  @Override
  public void save(Student entry) {
    try (final Connection connection = dataSource.getConnection()) {
      final PreparedStatement preparedStatement =
          connection.prepareStatement("INSERT INTO STUDENT(id,name) VALUES(?,?);");
      preparedStatement.setObject(1, entry.getId());
      preparedStatement.setObject(2, entry.getName());
      preparedStatement.executeUpdate();
    } catch (SQLException throwables) {
      throwables.printStackTrace();
    }
  }
}
