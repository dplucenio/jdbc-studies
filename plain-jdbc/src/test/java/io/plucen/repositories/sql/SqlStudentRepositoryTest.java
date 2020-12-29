package io.plucen.repositories.sql;

import static org.assertj.core.api.Assertions.assertThat;

import io.plucen.entities.Student;
import io.plucen.repositories.sql.migrations.Migrations;
import java.util.UUID;
import org.h2.jdbcx.JdbcDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SqlStudentRepositoryTest {

  private static JdbcDataSource dataSource;
  private static SqlStudentRepository sqlStudentRepository;

  @BeforeAll
  public static void globalSetup() {
    dataSource = new JdbcDataSource();
    dataSource.setURL("jdbc:h2:~/a2");
    dataSource.setUser("sa");
    dataSource.setPassword("sa");

    sqlStudentRepository = new SqlStudentRepository(dataSource);
  }

  @BeforeEach
  public void setup() {
    Migrations.clean(dataSource);
    Migrations.performMigrations(dataSource);
  }

  @Test
  public void repositoryShouldBeEmpty() {
    assertThat(sqlStudentRepository.index()).isEmpty();
  }

  @Test
  public void testSavingPersistance() {
    final Student johnLennon = new Student(UUID.randomUUID(), "John Lennon");
    final Student paulMcCartney = new Student(UUID.randomUUID(), "Paul McCartney");

    sqlStudentRepository.save(johnLennon);
    sqlStudentRepository.save(paulMcCartney);

    assertThat(sqlStudentRepository.index().stream().map(Student::getName))
        .containsExactlyInAnyOrder("John Lennon", "Paul McCartney");
  }
}
