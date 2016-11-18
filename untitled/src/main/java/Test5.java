/**
 * Created by admin on 18.11.2016.
 */
public class Test5 {
    static class A {
        int size = 1;
    }
    public static void main(String[] args) {
        A a = new A();

        if (a != null && a.size > 0) {
            System.out.println("OKEY");
        }

        A b = null;

        if (b != null && b.size > 0) {
            System.out.println("OKEY");
        }

        if (b != null & b.size > 0) {
            System.out.println("OKEY");
        }
    }
}
