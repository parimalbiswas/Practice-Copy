package comparable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Demo {
    public static void main(String[] args) {

        MarksComp marksComp = new MarksComp();
        // List<Student> list = new ArrayList<>(marksComp);

        Set<Student> list = new TreeSet<>(marksComp);

        list.add(new Student(10, "khokon", 500));
        list.add(new Student(20, "bulu", 300));
        list.add(new Student(3, "kalu", 900));
        list.add(new Student(15, "jadu", 320));

        System.out.println(list.size());

    }
}
