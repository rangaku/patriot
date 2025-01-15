package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class SignalReader {

  private final File radarSignalFile;

  public SignalReader(String radarSignalFilename) {
    URL url = getClass().getClassLoader().getResource(radarSignalFilename);
    assert url != null;
    this.radarSignalFile = new File(url.getPath());
  }

  public List<String> readRadarSignal() throws IOException {
    try (BufferedReader br = new BufferedReader(new FileReader(radarSignalFile))) {
      return br.lines().toList();
    }
  }
}
