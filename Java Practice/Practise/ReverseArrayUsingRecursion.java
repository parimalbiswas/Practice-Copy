/**
 * ReverseArrayUsingRecursion
 */
public class ReverseArrayUsingRecursion {

    public static void main(String[] args) {
        int arr[] = { 1, 5, 4, 9, 3, 6, 7, 5, 8, 1, 0, 4 };

        Jio(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }

    public static void Jio(int[] arr, int first, int last) {

        //System.out.println(first+"============"+last);
        if (first > last) {
            return;
        }
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;

        first++;
        last--;

        Jio(arr, first, last);

    }
}