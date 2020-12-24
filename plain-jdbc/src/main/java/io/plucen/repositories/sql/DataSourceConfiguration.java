package io.plucen.repositories.sql;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.postgresql.ds.PGSimpleDataSource;

public class DataSourceConfiguration {

  public static void createTables(DataSource dataSource) {
    try (Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement()) {
      statement.execute("CREATE TABLE if not exists person (id uuid,  name varchar);");
    } catch (SQLException exception) {
      System.out.println(exception.getMessage());
    }
  }

  public static DataSource getDataSource() {
    final Dotenv dotenv = Dotenv.load();

    final PGSimpleDataSource dataSource = new PGSimpleDataSource();
    dataSource.setURL(dotenv.get("DB_URL"));
    dataSource.setUser(dotenv.get("DB_USER"));
    dataSource.setPassword(dotenv.get("DB_PASSWORD"));
    return dataSource;
  }
}
