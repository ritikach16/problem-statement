import java.util.HashMap;
import java.util.List;

public class GetRoutes implements GetAllRoutes{

    @Override
    public void getRoute(int[] prev, int i, List<Integer> route)
    {
        if (i >= 0)
        {
            getRoute(prev, prev[i], route);
            route.add(i);
        }
    }
}
