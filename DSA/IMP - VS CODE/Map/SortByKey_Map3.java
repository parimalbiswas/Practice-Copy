import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByKey_Map3 {
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

        List<String> list = new ArrayList<>(map.keySet());

        Collections.sort(list);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ======= " + map.get(list.get(i)));
        }
    }
}
