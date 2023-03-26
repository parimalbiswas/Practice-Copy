public class CallByValueRef {
    int n = 500;

    public void Jio(int n) {
        n = n + 500;
    }

    public static void main(String[] args) {

        
        CallByValueRef obj1 = new CallByValueRef();
        //1
        System.out.println(obj1.n);
        obj1.Jio(obj1.n);
        //2
        System.out.println(obj1.n);

        

    }
}
