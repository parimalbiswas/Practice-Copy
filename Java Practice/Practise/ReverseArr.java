import java.util.ArrayList;
import java.util.List;

public class ReverseArr {
    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 9, 3, 6, 7, 5, 8, 1, 0, 4 };

        Jio(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void Jio(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            list.add(arr[i]);
        }

        System.out.println(list);

           int[] arr2 = list.toArray(new int[0]);


    }




}
