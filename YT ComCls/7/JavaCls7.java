
// Encapsulation Example Start
public class JavaCls7 {

    public static void main(String[] args) {
        Sure s1 = new Sure();
        System.out.println(s1.getName());
    }
}

class Sure {
    private String name = "Parimal";
    private int age = 30;
    private String tech = "Java";

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Encapsulation Example End