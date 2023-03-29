class Bathroom implements Runnable {

    @Override
     synchronized public void run() {
        try 
        {
            System.out.println(Thread.currentThread().getName() + " is entered Bathroom");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " is using Bathroom");
            Thread.sleep(3000);
            System.out.println(Thread.currentThread().getName() + " is exit Bathroom");
        } 
        catch (InterruptedException e) 
        {
            e.printStackTrace();
        }
    }

}

public class _1Resourse3Thread {
    public static void main(String[] args) {

        Bathroom bathroom = new Bathroom();
        Thread t1 = new Thread(bathroom);
        Thread t2 = new Thread(bathroom);
        Thread t3 = new Thread(bathroom);

        t1.setName("BOY");
        t2.setName("GIRL");
        t3.setName("TIKTOKER");

        t1.start();
        t2.start();
        t3.start();

    }
}
