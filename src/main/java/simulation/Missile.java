package simulation;

public class Missile {

  public Missile(double randomNumber) {
    this.randomNumber = randomNumber;
  }

  private static final double PK = .8;

  private final double randomNumber;

  public boolean hasHitTarget() {
    return randomNumber < PK;
  }
}
