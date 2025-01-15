package io;

public class OutputWriter {

  public void printOutput(int timestep, String message) {
    System.out.printf("Timestep: %d s. Message: %s%n", timestep, message);
  }
}
