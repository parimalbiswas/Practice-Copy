import java.util.HashMap;
import java.util.Map;

public class A {
    public static void main(String[] args) {
        Map<Student,String> hm1 = new HashMap<>();

        hm1.put(new Student(10,"n1",500),"Delhi");
        hm1.put(new Student(12,"n5",300),"Kolkata");
        hm1.put(new Student(11,"n9",900),"Odia");
        hm1.put(new Student(16,"n0",100),"Assam");


    }
}
