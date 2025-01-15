package simulation;

import java.util.List;

public class Radar {

  private final List<String> signals;

  Radar(List<String> signals) {
    this.signals = signals;
  }

  public String getSignal(int timeStep)
  {
    return signals.get(timeStep);
  }
}
