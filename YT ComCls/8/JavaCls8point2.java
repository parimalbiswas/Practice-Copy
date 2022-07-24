
public class JavaCls8point2 {
    public static void main(String[] args) {
        Alien a1 = new Alien();
        Alien a2 = new Alien();

        Alien.show();
    }
}

class Alien {
    int age; // Instance Variable
    String name;
    static String tech; // Class Variable (Common For All)

    public Alien() {
        System.out.println("in Constractor");
    }

    public static void show() {
        System.out.println("In Show");
    }
}


video 8  time 35:36