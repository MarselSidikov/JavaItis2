import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Model a = new Model.Builder()
                .age(22)
                .name("Marsel")
                .sex('m')
                .weight(66)
                .isCrocodile(false)
                .build();

        Model b = new Model.Builder()
                .age(22)
                .name("Marsel")
                .sex('m')
                .weight(66)
                .isCrocodile(false)
                .build();

        if (!(a == b)) {
            System.out.println("Fail equal");
        }

        if (a.equals(b)) {
            System.out.println("Success equals method");
        } else {
            System.out.println("Not Success equals method");
        }

        a = b;

        if (a == b) {
            System.out.println("Success equal");
        }

        String str = "Hello";

        Map<String, Model> map = new HashMap<String, Model>();
        Set<String> set = new HashSet<String>();














    }
}
