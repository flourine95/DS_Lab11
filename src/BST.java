import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    // Add element e into BST
    public void add(E e) {
        if (root == null) {
            root = new BNode<>(e);
        } else {
            root.add(e);
        }
    }

    // Add a collection of elements col into BST
    public void add(Collection<E> col) {
        for (E e : col) {
            add(e);
        }
    }

    // compute the depth of a node in BST
    public int depth(E node) {
        if (root == null) {
            return -1;
        }
        return root.depth(node);
    }

    // compute the height of BST
    public int height() {
        if (root == null) {
            return -1;
        }
        return root.height();
    }

    // Compute total nodes in BST
    public int size() {
        if (root == null) {
            return 0;
        }
        return root.size();
    }

    // Check whether element e is in BST
    public boolean contains(E e) {
        if (root == null) {
            return false;
        }
        return root.contains(e);

    }

    // Find the minimum element in BST
    public E findMin() {
        if (root == null) {
            return null;
        }
        return root.findMin();
    }

    // Find the maximum element in BST
    public E findMax() {
        if (root == null) {
            return null;
        }
        return root.findMax();
    }

    // Remove element e from BST
    public boolean remove(E e) {
        if (root == null || !root.contains(e)) {
            return false;
        }
        return root.remove(e);
    }

    // get the descendants of a node
    public List<E> descendants(E data) {
        if (root == null) {
            return null;
        }
        return root.descendants(data);
    }

    // get the ancestors of a node
    public List<E> ancestors(E data) {
        if (root == null) {
            return null;
        }
        return root.ancestors(data);
    }

    public BNode<E> getRoot() {
        return root;
    }

    // display BST using inorder
    public void inorder() {
        if (root == null) {
            return;
        }
        root.inorder();

    }

    // display BST using preorder approach
    public void preorder() {
        if (root == null) {
            return;
        }
        root.preorder();
    }
    public void postorder() {
        if (root == null) {
            return;
        }
        root.postorder();
    }
}