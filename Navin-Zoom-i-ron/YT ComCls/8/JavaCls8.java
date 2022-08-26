/**
 * JavaCls8
 */
public class JavaCls8 {

    public static void main(String[] args) {
        Alien a1 = new Alien();
        Alien a2 = new Alien();

        a1.age = 27;
        a1.name = "PArimal";
        a1.tech = "Java";

        a2.age = 5;
        a2.name = "Biswas";
        a2.tech = "Python";

        System.out.println(a1.tech);
        System.out.println(a2.tech);

    }
}

class Alien {
    int age; // Instance Variable
    String name;
    static String tech; // Class Variable (Common For All)

    public Alien() {
        System.out.println("in Constractor");
    }
}