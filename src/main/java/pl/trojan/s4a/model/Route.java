package pl.trojan.s4a.model;

import java.util.TreeMap;

public class Route {

  private int id;

  private final TreeMap<Long, Plane> planeAssignments = new TreeMap<>();

  public Route(int id, Plane plane){
    this.id = id;
    assignPlane(0, plane);
  }

  public void assignPlane(long time, Plane plane){
    if (planeAssignments.isEmpty() || planeAssignments.get(planeAssignments.lastKey()) == null) {
      planeAssignments.put(time, plane);
    } else throw new RuntimeException("Plane " + plane.getId() + " cannot be assign to route: " + this.id +
         ". Plane nr " + planeAssignments.get(planeAssignments.lastKey()).getId() + " operate this airline.");
  }

  public void withDrawPlane(long time){
    planeAssignments.put(time, null);
  }

  public int getCapacity(long time){

    long assignmentTime = planeAssignments.lastKey();

    Plane plane = planeAssignments.get(assignmentTime);

    if (plane == null) return 0;
    else return plane.getCapacityInPeriod(assignmentTime, time);

  }

  public int getId() {
    return id;
  }

}
