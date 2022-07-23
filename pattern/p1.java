public class p1 {
    public static void main(String[] args) {

        // int n = 5;
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
        // System.out.print("*");
        // } else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }

        // int n2 = 7;
        // for (int i = 0; i < n2; i++) {
        // for (int j = 0; j < n2; j++) {
        // if (i == 0 || j == (n2 - 1) / 2) {
        // System.out.print("*");
        // } else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }

        // int n3 = 7;
        // for (int i = 0; i < n3; i++) {
        // for (int j = 0; j < n3; j++) {
        // if ((i == 0 && j != 0 && j != n3 - 1)) {
        // System.out.print("*");
        // } else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }
        // (j = 0 && i != 0 && i != n3 - 1)

        // int n4 = 7;
        // for (int i = 0; i < n4; i++) {
        // for (int j = 0; j < n4; j++) {
        // if (j == 0 && i != 0|| j == n4-1 && i != 0 || i==(n4-1)/2 || i==0 && j!=0 &&
        // j!=n4-1) {
        // System.out.print("*");
        // } else {
        // System.out.print(" ");
        // }
        // }
        // System.out.println();
        // }



        // int n5 = 11;
        // for (int i = 0; i < n5; i++) {
        //     for (int j = 0; j < n5; j++) {
        //         if (i==j || i+j==n5-1 || i==0 ||j==0 || j==n5-1 || i==n5-1) {
        //             System.out.print("*");
        //         } else {
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }


        int n6 = 20;
        for (int i = 0; i < n6; i++) {
            for (int j = 0; j < n6; j++) {
                if (i==j || i+j==n6-1 || i==0 ||j==0 || j==n6-1 || i==n6-1 || i+j==(n6-1)/2) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }





    }
}
