/**
 * Demo
 */

class X3 extends Throwable {

    X3(String x) {
        super(x);
    }

    X3() {

    }

}

public class Demo {

    public static void main(String[] args) throws X3 {
        X3 x3 = new X3();
        throw new X3("Jio KAKA");
    }

}