import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoList {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(10, "parimal", 256));
        list.add(new Student(16, "Bubai", 3246));
        list.add(new Student(12, "Navneet", 639));
        list.add(new Student(15, "avisek", 256));

        // Collections.sort(list, (a,b)->a.getMarks()>b.getMarks() ? +1 : -1);

        Collections.sort(list, (a, b) -> {
            if (a.getMarks() > b.getMarks()) {
                return +1;
            } else if (a.getMarks() < b.getMarks()) {
                return -1;
            } else {
                return a.getName().compareTo(b.getName());
            }
        }

        );

        list.forEach(s -> System.out.println(s));

    }
}
