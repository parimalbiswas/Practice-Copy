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

        System.out.println("-------------");
        System.out.println();

        var times1 = 5;
        for (var i = 0; i < times1; i++) {
            for (var j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

        System.out.println("-------------");
        System.out.println();

        var times3 = 5;
        for (var i = 0; i < times3; i++) {
            for (var j = 0; j < times3; j++) {

                if (i == 0 || i == times3 - 1 || j == 0 || j == times3 - 1) {
                    System.out.print("*");
                }

                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }





        System.out.println("-------------");
        System.out.println();


        var times4 = 5;
        for (var i = 0; i < times4; i++) {
            for (var j = 0; j < times4; j++) {

                if (i == (times4-1)/2 || j == 0 || j == times4 - 1) {
                    System.out.print("*");
                }

                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }

        System.out.println("-------------");
        System.out.println();
        
        var n5 = 5;
        for (var i = 0; i < n5; i++) {
            for (var j = 0; j < n5; j++) {

                if (i == (n5-1)/2 || j == 0 || j == n5 - 1) {
                    System.out.print("*");
                }

                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }


    }
}
