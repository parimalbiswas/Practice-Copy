import java.util.HashMap;
import java.util.Map;

/**
 * MapTest
 */
public class MapTest {

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 2);
        map.put(5, 2);
        map.put(3, 2);
        map.put(4, 2);

        System.out.println(map);

        for (Map.Entry<Integer, Integer> el : map.entrySet()) {

        }
    }
}