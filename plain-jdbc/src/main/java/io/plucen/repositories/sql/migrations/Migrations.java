package io.plucen.repositories.sql.migrations;

import javax.sql.DataSource;
import org.flywaydb.core.Flyway;

public class Migrations {
  public static void performMigrations(DataSource dataSource) {
    Flyway.configure().dataSource(dataSource).load().migrate();
  }

  public static void clean(DataSource dataSource) {
    Flyway.configure().dataSource(dataSource).load().clean();
  }
}
