package pl.trojan.s4a;

import pl.trojan.s4a.io.InputDto;
import pl.trojan.s4a.io.SimpleReader;
import pl.trojan.s4a.logic.S4System;

public class App {

  public static void main(String[] args) {

    String fileName = (args.length > 0) ? args[0] : "input.txt";
    InputDto input = SimpleReader.process(fileName);

    S4System s4System = new S4System(input.getCapacities(), input.getQueries());
    s4System.start();

  }
}
