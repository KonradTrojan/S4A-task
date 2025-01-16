package pl.trojan.s4a.io;

import java.util.List;
import pl.trojan.s4a.model.Query;

public class InputDto {

  List<Integer> capacities;
  List<Query> queries;

  public InputDto(List<Integer> capacities, List<Query> queries) {
    this.capacities = capacities;
    this.queries = queries;
  }

  public List<Integer> getCapacities() {
    return capacities;
  }

  public List<Query> getQueries() {
    return queries;
  }
}
