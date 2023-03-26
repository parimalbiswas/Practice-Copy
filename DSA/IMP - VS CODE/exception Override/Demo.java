import java.io.IOException;

/**
 * Demo
 */

class A {
    public void M1() throws ArithmeticException {
        System.out.println("Jio");
    }
}

class B extends A {

    @Override
    public void M1() throws NullPointerException {
        System.out.println("Kaka");
    }
}

public class Demo {
    public static void main(String[] args) {

    }
}