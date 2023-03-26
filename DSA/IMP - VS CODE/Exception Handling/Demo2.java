class X1 extends Exception {

    X1(String x) {
        super(x);
    }

    X1() {

    }

}

/**
 * InnerDemo2
 */
public class Demo2 {

    public static void main(String[] args) throws X1 {
        X1 cX1 = new X1();
        throw new X1("Jio KAKA");
    }

    // public void Jio() {

    // }

}
