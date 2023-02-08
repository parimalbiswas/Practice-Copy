package comparableMethod;

import java.util.*;

public class Demo00012 {
    public static void main(String[] args) {

          //System.out.println("uuuuuuuuuuuuu");

         CompRoll compRoll = new CompRoll();

        TreeSet<Student> list = new TreeSet<>(compRoll);

         //Set<Student> list = new HashSet<>(compRoll);

         list.add(new Student(10, "kalu", 200));
         list.add(new Student(12, "bulu", 145));
         list.add(new Student(1, "lali", 986));
         list.add(new Student(11, "khlocx", 569));


         list.forEach(student -> System.out.println(student));
    }
}
