/**
 * Created by admin on 14.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Class clazz = new Integer(23).getClass();
        Class clazz1 = new Integer(22).getClass();
        System.out.println(clazz == clazz1);
    }
}
