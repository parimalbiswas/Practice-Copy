public class star {
    public static void main(String[] args) {

        // int i=1;
        // while (i<=5) {
        // System.out.println("*");
        // i++;
        // }

        // int i = 0;
        // do {
        // System.out.print("*");
        // i++;
        // } while (i <0);

        var times = 5;
        for (var i = 0; i < times; i++) {
            for (var j = 0; j < times; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }
}
