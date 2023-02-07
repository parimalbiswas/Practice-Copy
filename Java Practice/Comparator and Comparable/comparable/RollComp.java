package comparable;

import java.util.Comparator;

public class RollComp implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {

        return o1.getRoll() > o2.getRoll() ? +1 : -1;
    }

}
