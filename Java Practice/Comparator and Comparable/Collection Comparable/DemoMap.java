import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DemoMap {
    public static void main(String[] args) {
        Map<Student, Integer> map = new LinkedHashMap<>();
        map.put((new Student(10, "parimal", 256)), 9);
        map.put((new Student(16, "Bubai", 3246)), 6);
        map.put((new Student(12, "Navneet", 639)), 1);
        map.put((new Student(15, "avisek", 256)), 9);

        List<Map.Entry<Student, Integer>> list = new LinkedList<Map.Entry<Student, Integer>>(map.entrySet());

        Collections.sort(list, (a, b) -> a.getKey().getMarks() > b.getKey().getMarks() ? +1 : -1);

        System.out.println(list);

        // for (Map.Entry<Student, Integer> aa : list) {
        // map.put(aa.getKey(), aa.getValue());
        // }

        System.out.println(map);

    }
}
