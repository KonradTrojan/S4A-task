package pl.trojan.s4a.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import pl.trojan.s4a.model.Plane;
import pl.trojan.s4a.model.Query;
import pl.trojan.s4a.model.Route;


public class S4System {

    private final TreeMap<Integer, Route> routeMap  = new TreeMap<>();
    private final TreeMap<Integer, Plane> planeMap  = new TreeMap<>();
    private final List<Query> queryMap  = new ArrayList<>();


    public S4System(List<Integer> capacities, List<Query> queries){

        for (int i = 0; i < capacities.size(); i++){
            Plane plane = new Plane(i + 1, capacities.get(i));
            this.planeMap.put(i + 1, plane);
            Route route = new Route(i + 1, plane);
            this.routeMap.put(i + 1, route);
        }

      this.queryMap.addAll(queries);
    }

    public void start(){
        for (Query query : queryMap){

            int[] args = query.getArgs();
            long time = query.getTime();

            switch (query.getType()){

                case P : {
                    Plane plane = planeMap.get(args[0]);
                    plane.updateMaxCapacity(time,  args[1]);
                    break;
                }

                case C : {
                    Route route = routeMap.get(args[0]);
                    route.withDrawPlane(time);
                    break;
                }

                case A : {
                    Plane plane = planeMap.get(args[0]);
                    plane.updateMaxCapacity(time, args[1]);
                    Route route = routeMap.get(args[0]);
                    route.assignPlane(time, plane);
                    break;
                }

                case Q : {
                    Map<Integer, Route> subRoutes = routeMap.subMap(args[0], true, args[1], true);
                    int totalCapacity = subRoutes.values().stream()
                        .mapToInt(r -> r.getCapacity(time))
                        .sum();
                    System.out.println(totalCapacity);
                    break;
                }
            }
        }
    }
}