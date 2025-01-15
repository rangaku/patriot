package simulation;

import io.OutputWriter;
import io.SignalReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Simulator {

  private static final String RADAR_DATA_FILENAME = "radar_data.csv";

  private static final int RANDOM_SEED = 1;

  public static void main(String[] args) throws IOException {

    List<String> radarSignals = new SignalReader(RADAR_DATA_FILENAME).readRadarSignal();
    OutputWriter outputWriter = new OutputWriter();

    Radar radar = new Radar(radarSignals);
    Random randomNumberGenerator = new Random(RANDOM_SEED);
    MissileLauncher missileLauncher = new MissileLauncher(randomNumberGenerator);

    for (int timeStep = 0; timeStep < radarSignals.size(); timeStep++) {

      String radarSignal = radar.getSignal(timeStep);
      if (IFF.isEnemyObject(radarSignal)) {
        Missile missile = missileLauncher.sendMissile();
        if (missile.hasHitTarget()) {
          outputWriter.printOutput(timeStep, "Enemy object detected. Missile launched, hit target.");
        } else {
          outputWriter.printOutput(timeStep, "Enemy object detected. Missile launched, did not hit target.");
        }
      } else {
        outputWriter.printOutput(timeStep, "No enemy object detected.");
      }
    }
  }
}
