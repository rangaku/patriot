package simulation;

import java.util.Random;

public class MissileLauncher {

  public MissileLauncher(Random randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  private final Random randomNumberGenerator;

  public Missile sendMissile() {
    return new Missile(randomNumberGenerator.nextDouble());
  }
}
