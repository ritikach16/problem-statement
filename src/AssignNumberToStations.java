import java.util.HashMap;

public class AssignNumberToStations implements AssignCode{
    @Override
   public HashMap<String, Integer> assignNumber(){
       HashMap<String, Integer> stationMap = new HashMap<>();
        stationMap.put("Mayur Vihar", 0);
       stationMap.put("Noida", 1);
       stationMap.put("Dwarka", 2);
       stationMap.put("Mandi House", 3);
       stationMap.put("Nirman Vihar", 4);
       return stationMap;
    }

    @Override
    public HashMap<Integer, String> assignName(){
        HashMap<Integer, String> stationMap = new HashMap<>();
        stationMap.put(0, "Mayur Vihar");
        stationMap.put(1, "Noida");
        stationMap.put(2, "Dwarka");
        stationMap.put(3, "Mandi House");
        stationMap.put(4, "Nirman Vihar");
        return stationMap;
    }
}