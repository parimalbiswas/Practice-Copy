public class ReveseIntegerWAY2 {
    public static void main(String[] args) {
        int x = 564;
        String y = "";
        int res = 0;
        while (x>0) {
            int mod = x%10;
            res = res * 10 + mod;
            x = x/10;
            
            
            //System.out.println(mod); 
        }

        System.out.println(res);
        
    
    }
}
