public class ReveseInteger {

    public static void main(String[] args) {
        int x = 564;
        StringBuilder y = new StringBuilder("");
        while (x>0) {
            int mod = x%10;
             x = x/10;
            
            y.append(mod);
            System.out.println(mod); 
        }

        
        System.out.println(Integer.parseInt(y.toString()));
        
    }
    
}
