/**
 * Single
 */
class Demo1 implements Runnable {

    @Override
    public void run() {
        doa();
    }

    public void doa() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

class Demo2 implements Runnable {
    @Override
    public void run() {
        doa();
    }

    public void doa() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

class Demo3 implements Runnable {
    @Override
    public void run() {
        doa();
    }

    public void doa() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        }
    }
}

public class Single {

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        Demo2 demo2 = new Demo2();
        Demo3 demo3 = new Demo3();

        Thread t1 = new Thread(demo1);
        Thread t2 = new Thread(demo2);
        Thread t3 = new Thread(demo3);

        t1.start();
        t2.start();
        t3.start();

    }
}