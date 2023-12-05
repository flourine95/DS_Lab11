import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Integer> ints = new ArrayList<>(List.of(25, 15, 50, 10, 22, 35, 70, 4, 12, 18, 24, 31, 44, 66, 90));
        BST<Integer> bst = new BST<>();
        bst.add(ints);
        BTreePrinter.printNode(bst.getRoot());
        System.out.println("Depth of " + ints.get(0) + ": " + bst.depth(ints.get(0)));
        System.out.println("Height: " + bst.height());
        System.out.println("Size: " + bst.size());
        System.out.println("Min: " + bst.findMin());
        System.out.println("Max: " + bst.findMax());
        System.out.println("Remove " + ints.get(0) + ": " + bst.remove(ints.get(0)));
        BTreePrinter.printNode(bst.getRoot());
        System.out.println("Ancestors: " + bst.ancestors(25));
    }
}
