import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
        LinkedMyList list = new LinkedMyList();
        list.add(3);
        list.add(4);
        list.addFirst(2);
        list.insert(78, 0);
        System.out.println(list.size());
        System.out.println(Arrays.toString(list.toArray()));
    }
}
