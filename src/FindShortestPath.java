import java.util.*;

public class FindShortestPath {

    public static void findShortestPaths(Map graph, int source, int n, int dest, HashMap<Integer, String> stationMap)
    {
        if(source < 0 || dest < 0){
            System.out.println("Please enter the correct station details");
            return;
        }
        if(source == dest){
            System.out.printf("Path (%d —> %d): Minimum cost = %d\n", source, dest, 0);
            return;
        }
        PriorityQueue<BusStation> minHeap;
        minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        minHeap.add(new BusStation(source, 0));

        List<Integer> dist;
        dist = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));

        dist.set(source, 0);

        boolean[] done = new boolean[n];
        done[source] = true;

        int[] prev = new int[n];
        prev[source] = -1;

        while (!minHeap.isEmpty())
        {
           BusStation node = minHeap.poll();

           int u = node.vertex;

           for (Route edge: graph.adjList.get(u))
            {
                int v = edge.dest;
                int weight = edge.distance;

               if (!done[v] && (dist.get(u) + weight) < dist.get(v))
                {
                    dist.set(v, dist.get(u) + weight);
                    prev[v] = u;
                    minHeap.add(new BusStation(v, dist.get(v)));
                }
            }

           done[u] = true;
        }
        GetRoutes getRoutes = new GetRoutes();
        List<Integer> route = new ArrayList<>();

        for (int i=0; i<n; i++)
        {
            if (i != source && dist.get(i) != Integer.MAX_VALUE && i == dest)
            {
                getRoutes.getRoute(prev, i, route);
                System.out.printf("Path (%s —> %s): Minimum cost = %d, Route: \n",
                        stationMap.get(source), stationMap.get(i), dist.get(i));
                for(int k : route){
                    System.out.println( stationMap.get(k));
                }
                route.clear();
            }
        }
    }
}
