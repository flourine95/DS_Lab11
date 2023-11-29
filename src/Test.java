import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(List.of(3, 1, 2, 4, 0,5,7,6));

        BST<Integer> bst = new BST<>();
        bst.add(integers);
        BTreePrinter.printNode(bst.getRoot());
        System.out.println(bst.depth(3));
        System.out.println(bst.depth(5));
        System.out.println(bst.depth(7));
        System.out.println(bst.depth(6));
        System.out.println("h"+bst.height(bst.getRoot()));
        System.out.println("a: "+ bst.depth(611));
        System.out.println("h2: "+ bst.height());
    }
}
