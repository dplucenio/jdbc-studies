package io.plucen.repositories.sql;

import io.plucen.repositories.sql.migrations.Migrations;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SqlStudentRepositoryTest {

  private static JdbcDataSource dataSource;

  @BeforeAll
  public static void globalSetup() {
    dataSource = new JdbcDataSource();
    dataSource.setURL("jdbc:h2:~/a2");
    dataSource.setUser("sa");
    dataSource.setPassword("sa");
  }

  @BeforeEach
  public void setup() {
    Migrations.clean(dataSource);
    Migrations.performMigrations(dataSource);
  }

  @Test
  public void saveMustPersistEntry() throws SQLException {
    //    try {
    final Connection connection = dataSource.getConnection();
    final ResultSet resultSet =
        connection.prepareStatement(("SELECT * " + "FROM person")).executeQuery();
    System.out.println(resultSet);
    //    } catch (SQLException exception) {
    //      exception.printStackTrace();
    //    }
  }
}
