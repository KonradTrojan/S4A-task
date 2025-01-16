package pl.trojan.s4a.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pl.trojan.s4a.model.Query;

public class SimpleReader {

  public static InputDto process(String fileName) {

    File file = new File(fileName);

    if (!file.isAbsolute()) {
      file = new File(System.getProperty("user.dir"), fileName);
    }

    if (file.exists() && file.isFile()) {
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

        int routeNum = 0;
        int queryNum = 0;
        List<Integer> capacities = new ArrayList<>();
        List<Query> queries = new ArrayList<>();

        int counter = 0;
        String line;

        while ((line = reader.readLine()) != null) {
          if (counter == 0) {
            String[] parts = line.split(" ");
            routeNum = Integer.parseInt(parts[0]);
            queryNum = Integer.parseInt(parts[1]);
          }
          if (counter == 1) {
            String[] parts = line.split(" ");
            for (String part : parts) {
              capacities.add(Integer.parseInt(part));
            }
          }
          if (counter >= 2) {
            String[] parts = line.split(" ");
            queries.add(new Query(parts));
          }

          counter++;
        }

        checkDataConsistency(routeNum, capacities.size(), queryNum, queries.size());

        return new InputDto(capacities, queries);

      } catch (IOException e) {
        throw new RuntimeException("Error reading file: " + e.getMessage());
      }
    }
    throw new RuntimeException("Error reading file.");
  }

  private static void checkDataConsistency(int routeNum, int capacitiesSize, int queryNum, int queriesSize){
    if (routeNum != capacitiesSize)
      throw new RuntimeException(
          "The route number declared in first line does not agree with an information in second line.");
    if (queryNum != queriesSize)
      throw new RuntimeException(
          "The query number declared in first line does not agree with the current number of queries lines.");
  }
}
