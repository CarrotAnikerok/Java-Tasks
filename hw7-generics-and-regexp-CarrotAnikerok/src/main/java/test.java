import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class test {
    public static void main(String[] args) {
        MyBinaryTree<Integer> tree = new MyBinaryTree();
        tree.add(5);
        tree.add(3);
        tree.add(7);
        tree.add(2);
        tree.add(4);
        tree.add(9);
        tree.add(5);
        tree.add(3);
        System.out.println(tree.toArray(new Integer[0]));
        System.out.println(tree.toArray(new Integer[0]));
        System.out.println(tree.receiveDescendant(tree.rootNode.leftChild).value);
        System.out.println(tree.size());
        System.out.println(tree.contains(11));
    }
}
