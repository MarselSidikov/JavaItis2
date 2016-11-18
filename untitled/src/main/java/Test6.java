class Super {
    static int a = 0;
}

class Child extends Super {
    static int a = 1;
}

public class Test6 {
    public static void main(String[] args) {
        int a = 2;
        System.out.println(Child.a);
    }
}
