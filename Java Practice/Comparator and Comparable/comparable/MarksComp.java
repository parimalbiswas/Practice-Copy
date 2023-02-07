package comparable;

import java.util.Comparator;

/**
 * MarksComp
 */
public class MarksComp implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getMarks() > o2.getMarks() ? +1 : -1;

    }

}