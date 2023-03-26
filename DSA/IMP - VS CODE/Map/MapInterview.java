import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.w3c.dom.TypeInfo;

public class MapInterview {

    public static Map<Integer, String> map = new HashMap<>();

    public static void main(String[] args) {
        String str = "t1e1s2t, Hell1o, 1th1e, fir2st1";

        // Step 1: t1e1s2t, Hell1o, 1th1e, fir2st1

        // Step 2: t1e1s2t(4), Hell1o(1), 1th1e(2), fir2st1(3)

        // Step 3: test (4), Hello (1), the (2), first (3)

        // Step 5: Hello (1), the (2), first (3), test (4)

        // Output: Hello the first test

        String arr[] = str.split(",");

        // System.out.println(Arrays.toString(arr));

        for (int i = 0; i < arr.length; i++) {

            Jio(arr[i].trim());
        }

        printmap();
    }

    private static void Jio(String str) {
        str.trim();
        // System.out.println(str.trim());

        List<Integer> list = new ArrayList<>();
        String onlyStr = new String();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                // System.out.println(str.charAt(i));

                int x = Integer.parseInt(String.valueOf(str.charAt(i)));

                list.add(x);

            } else {
                onlyStr += (str.charAt(i));
            }
        }

        // System.out.println(list);

        Integer count = 0;

        for (Integer el : list) {
            count += (Integer) el;
        }

        // System.out.println(count);
        map.put(count, onlyStr);

    }

    public static void printmap() {
        // System.out.println(map);
        StringBuilder sBuilder = new StringBuilder();
        for (Map.Entry<Integer, String> el : map.entrySet()) {
            sBuilder.append(el.getValue() + " ");
        }

        System.out.println(sBuilder);
    }

}
