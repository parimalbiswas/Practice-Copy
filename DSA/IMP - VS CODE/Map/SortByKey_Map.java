import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * SortByKey_Map
 */
public class SortByKey_Map {

    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<>();
        map.put(11, "Parimal");
        map.put(2, "Biswas");
        map.put(1, "Jio");
        map.put(10, "Meet");
        map.put(9, "Samsung");
        map.put(0, "iBall");
        map.put(4, "Nokia");

        System.out.println(map);
        // TreeMap<Integer, String> treeMap = new TreeMap<>(map);

        // System.out.println(treeMap);

        // int min = 0;
        // for (Map.Entry<Integer, String> el : map.entrySet()) {
        // if (el.getKey() > min) {
        // min = el.getKey();
        // }
        // }

    }
}