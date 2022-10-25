public class JavaClspoint3 {
    public static void main(String[] args) {
        Alien.show();
        Alien a1 = new Alien();
        a1.show1();
    }
}

class Alien {
    public static void show() {
        System.out.println("in Show");
    }

    public void show1() {
        System.out.println("in Show1");
    }
}

// video 8 time 35:36