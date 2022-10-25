class Laptop {
    // know (Proparty) --Variables
    // Does \ Action (Behaviour) --Methods

    String cpu;
    int ram;
    int hdd;

    // computation, processing,gaming, throw -- Methods
    public void compile() {
        System.out.println("Compileing");
        System.out.println(ram);
    }
}

class Test {

}


public class Demo {

    public static void main(String[] args) {
        Laptop obj = new Laptop(); // Type Variablename
        obj.ram = 16;
        obj.compile();
    }
}