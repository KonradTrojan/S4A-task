package pl.trojan.s4a.model;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class Plane {

  private final int id;
  private final TreeMap<Long, Integer> maxCapacityHistory = new TreeMap<>();

  public Plane(int id, int capacity){
    this.id = id;
    this.maxCapacityHistory.put(0L, capacity);
  }

  public void updateMaxCapacity(long time, int newCapacity){
    maxCapacityHistory.put(time, newCapacity);
  }

  private int getMaxCapacityAt(long time){
    return maxCapacityHistory
        .floorEntry(time).getValue();
  }

  public int getId(){
    return this.id;
  }


  public int getCapacityInPeriod(long firstTime, long lastTime) {

    int sum = 0;

    NavigableMap<Long, Integer> relevantEntries = maxCapacityHistory.subMap(firstTime, true, lastTime, false);
    int currentCapacity = getMaxCapacityAt(firstTime);
    long previousTime = firstTime;

    for (Map.Entry<Long, Integer>  entry : relevantEntries.entrySet()) {
      long time = entry.getKey();
      sum += (int) (currentCapacity * (time - previousTime));
      currentCapacity = entry.getValue();
      previousTime = time;
    }

    sum += (int) (currentCapacity * (lastTime - previousTime));

    return sum;
  }

}
