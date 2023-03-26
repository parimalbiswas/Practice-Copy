import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * ListX
 */
public class ListX {

    public static void main(String[] args) {
        List<Integer> li = Arrays.asList(25, 56, 45, 21, 45, 56, 25, 77, 1);

        System.out.println(li);

        List<Integer> distint = li.stream().distinct().collect(Collectors.toList());

        System.out.println(distint);

        ///////////////////////////////////////////////////////////////////////////

        // Iterator<Integer> iterator = distint.iterator();

        // while (iterator.hasNext()) {
        // li.remove(iterator.next());
        // }
        // // for (Integer integer : distint) {
        // // li.remove(integer);
        // // }

        // System.out.println(li);

        ////////////////////////////////////////////////////////////////////////////

        Set<Integer> unique1 = new HashSet<>();
        
        Set<Integer> set = li.stream().filter(n -> !unique1.add(n)).collect(Collectors.toSet());

        System.out.println(set);

        // List<Integer> unique =
        // li.stream().mapToInt(null).collect(Collectors.toList());
    }
}