class X extends Thread {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();
        System.out.println("xxxxxxxx");
    }
}

public class ThreadCallUsingRunMethod {
    public static void main(String[] args) {
        X x = new X();
        // x.start();
        x.run();
    }
}
