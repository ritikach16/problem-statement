import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    List<List<Route>> adjList = null;

    Map(List<Route> routes, int n)
    {
        adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (Route route: routes) {
            adjList.get(route.source).add(route);
        }
    }
}
