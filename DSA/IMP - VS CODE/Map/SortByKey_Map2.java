import java.util.LinkedHashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortByKey_Map2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Parimal", 5);

        map.put("Biswas", 2);
        map.put("Jio", 1);
        map.put("Meet", 10);
        map.put("Samsung", 9);
        map.put("IBall", 0);
        map.put("Nokia", 4);

        System.out.println(map);

        TreeMap<String, Integer> treeMap = new TreeMap<>(map);

        System.out.println(treeMap);

        for (Map.Entry<String, Integer> el : treeMap.entrySet()) {
            System.out.println(el.getKey() + "=======" + el.getValue());
        }

        
    
    }
}
