public class CallByRef {
    int n = 500;

    public void Jio(CallByRef obj) {
        obj.n = obj.n + 500;
    }

    public static void main(String[] args) {

        CallByRef obj1 = new CallByRef();
        // 1
        System.out.println(obj1.n);
        obj1.Jio(obj1);
        // 2
        System.out.println(obj1.n);

    }
}
