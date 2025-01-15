package simulation;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IFF {

  private IFF() {}

  public static boolean isEnemyObject(String radarSignal) {
    List<Integer> decimalValues = Arrays.stream(radarSignal.split(";")).map(stringValue -> Integer.parseInt(stringValue, 2)).toList();

    Map<Boolean, List<Integer>> valuesGroupedByIsUneven = decimalValues.stream().collect(Collectors.groupingBy(IFF::isUneven));

    return valuesGroupedByIsUneven.get(true).size() > valuesGroupedByIsUneven.get(false).size();
  }

  private static boolean isUneven(int value) {
    return value % 2 != 0;
  }
}
