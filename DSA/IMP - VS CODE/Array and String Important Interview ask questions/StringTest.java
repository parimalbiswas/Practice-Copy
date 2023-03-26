/**
 * StringTest
 */
public class StringTest {

    public static void Jio(String str) {
        String arr1[] = str.split(",");

        // for (String string : arr1) {
        // System.out.println(string);
        // }

        StringBuilder sb1 = new StringBuilder();

        for (int i = arr1.length - 1; i >= 0; i--) {
            if (i == 0) {
                sb1.append(arr1[i]);
            } else {
                sb1.append(arr1[i] + " ");
            }

        }

        System.out.println(sb1);
    }

    public static void main(String[] args) {
        String str = "I,am,parimal,biswas";
        StringTest.Jio(str);

    }
}