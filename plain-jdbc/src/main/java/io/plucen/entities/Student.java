package io.plucen.entities;

import java.util.UUID;
import lombok.Data;

@Data
public class Student implements Identifiable<UUID> {
  private final UUID id;
  private final String name;
}
