import com.google.common.base.Splitter;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        String names = "Marsel, Nastya, Ilya, Anatoliy";

        Splitter splitter = Splitter.on(", ");

        Iterable<String> namesAsSequense = splitter.split(names);

        Iterator<String> iterator = namesAsSequense.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
