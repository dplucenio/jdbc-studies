package io.plucen.entities;

import static org.assertj.core.api.Assertions.assertThat;

import io.plucen.repositories.fakes.FakeStudentRepository;
import java.util.UUID;
import org.junit.jupiter.api.Test;

public class StudentTest {

  @Test
  public void testStudentCreation() {
    final Student johnLennon = new Student(UUID.randomUUID(), "John Lennon");
    final Student paulMcCartney = new Student(UUID.randomUUID(), "Paul McCartney");
    assertThat(johnLennon.getName()).isEqualTo("John Lennon");

    final FakeStudentRepository fakeStudentRepository = new FakeStudentRepository();
    fakeStudentRepository.save(johnLennon);
    fakeStudentRepository.save(paulMcCartney);
    System.out.println(fakeStudentRepository.index());
  }
}
