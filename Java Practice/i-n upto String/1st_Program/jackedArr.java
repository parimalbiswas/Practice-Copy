public class jackedArr {
    public static void main(String[] args) {
        // int num[][] = new int[4];
        int num1[][] = { { 3, 5, 5 }, { 7, 6, 3 }, { 8, 2, 6 } };

        int num2[][] = { { 3, 5, 5, 5 }, { 7, 6, 3 }, { 8, 2 } };

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num1.length; j++) {
                System.out.print(num1[i][j] + " ");
            }
            System.out.println();
        }


        for (int i = 0; i < num2.length; i++) {
            for (int j = 0; j < num2[i].length; j++) {
                System.out.print(num2[i][j] + " ");
            }
            System.out.println();
        }

    }
}
