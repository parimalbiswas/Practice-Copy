class X2 extends RuntimeException {

    X2(String x) {
        super(x);
    }

    X2() {

    }

}

public class Demo3 {
    public static void main(String[] args) {
        X2 x2 = new X2();
        throw new X2("Jio Mama");
    }

}
