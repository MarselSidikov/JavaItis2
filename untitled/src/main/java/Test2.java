/**
 * Created by admin on 18.11.2016.
 */
public class Test2 {

    static class MyInteger {
        public int x;
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    public static void swap(MyInteger a, MyInteger b) {
        int temp = a.x;
        a.x = b.x;
        b.x = temp;
    }

    public static void main(String[] args) {
        int x = 2;
        int y = 4;

        swap(x, y);


        System.out.println("X = " + x + " Y = " + y);

        MyInteger a = new MyInteger();
        MyInteger b = new MyInteger();
        a.x = 6;
        b.x = 7;

        swap(a, b);

        System.out.println("A = " + a.x + " B = " + b.x);
    }
}
