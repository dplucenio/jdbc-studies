package io.plucen.app;

import io.plucen.migrations.Migrations;

public class App {
  public static void main(String[] args) {
    Migrations.main(args);
    System.out.println("This is the migration-ci app");
  }
}
