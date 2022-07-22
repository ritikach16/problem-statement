import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class BusTravellingSystem {
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter your Starting point");
        String src = scn.nextLine();

        System.out.println("Enter Destination");
        String dest = scn.nextLine();

        int n = 5;
        AssignNumberToStations assignStationNumber = new AssignNumberToStations();
        HashMap<String, Integer> stationCodeMap = assignStationNumber.assignNumber();
        HashMap<Integer, String> stationNameMap = assignStationNumber.assignName();
        List<Route> edges = Arrays.asList(
                new Route(0, 1, 10), new Route(0, 4, 3), new Route(1, 2, 2),
                new Route(1, 4, 4), new Route(2, 3, 9), new Route(3, 2, 7),
                new Route(4, 1, 1), new Route(4, 2, 8), new Route(4, 3, 2)
        );

        Map graph = new Map(edges, n);
        FindShortestPath shortestPath = new FindShortestPath();
            shortestPath.findShortestPaths(graph, stationCodeMap.get(src), n, stationCodeMap.get(dest), stationNameMap);
    }

}
