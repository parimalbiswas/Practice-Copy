

/**
 * ReverseStringUsingRecursion
 */
public class ReverseStringUsingRecursion {

    public static void main(String[] args) {
        String str = "Parimal Bubai";

        String x = Jio(str, "", str.length() - 1);

        System.out.println(x);

    }

    public static String Jio(String str, String newStr, int last) {

        //System.out.println(newStr);

        if (last < 0) {
            return newStr;
        }
        else{
            newStr += Character.toString(str.charAt(last));
            last--;
    
            return Jio(str, newStr, last);
            
        }

        

    }
}