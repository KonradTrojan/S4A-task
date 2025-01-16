package pl.trojan.s4a.model;

import java.util.Arrays;

public class Query {

  private final QueryType type;
  private final int time;
  private final int[] args;

  public Query(String[] inputArgs) {

    this.type = QueryType.valueOf(inputArgs[0]);
    this.time = Integer.parseInt(inputArgs[inputArgs.length - 1]);
    this.args = Arrays.stream(inputArgs, 1, inputArgs.length - 1)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public QueryType getType(){
    return this.type;
  }

  public int getTime() {
    return time;
  }

  public int[] getArgs() {
    return args;
  }
}
