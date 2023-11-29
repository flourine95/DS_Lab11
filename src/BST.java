import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST<E extends Comparable<E>> {
    private BNode<E> root;

    public BST() {
        this.root = null;
    }

    // Add element e into BST
    public void add(E e) {
        BNode<E> value = new BNode<>(e);
        if (root == null) {
            System.out.println("Add ROOT sucess w. value: " + value.getData());
            root = value;
        } else {
            BNode<E> temp = root;
            while (temp != null) {
                if (e.compareTo(temp.getData()) > 0) {
                    if (temp.getRight() == null) {
                        temp.setRight(value);
                        System.out.println("Add RIGHT sucess w. value: " + value.getData());
                        break;
                    } else {
                        temp = temp.getRight();
                    }
                } else {
                    if (temp.getLeft() == null) {
                        temp.setLeft(value);
                        System.out.println("Add LEFT sucess w. value: " + value.getData());
                        break;
                    } else {
                        temp = temp.getLeft();
                    }
                }
            }
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
        int depth = 0;
        boolean isFinded = false;
        BNode<E> current = root;
        while (current != null) {
            if (node.compareTo(current.getData()) < 0) {
                current = current.getLeft();
            } else if (node.compareTo(current.getData()) > 0) {
                current = current.getRight();
            } else {
                isFinded = true;
                break;
            }
            depth++;
        }
        return isFinded ? depth : -1;
    }


    // compute the height of BST
    public int height() {
        if (root == null) {
            return 0;
        }
        Queue<BNode<E>> q = new LinkedList<>();
        q.add(root);
        int height = 0;
        while (!q.isEmpty()) {
            BNode<E> node = q.remove();
            if (node.getLeft() != null) {
                q.add(node.getLeft());
            }
            if (node.getRight() != null) {
                q.add(node.getRight());
            }
        }
        return 1;
    }

    public int height(BNode<E> root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.getLeft());
        int rightHeight = height(root.getRight());

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Compute total nodes in BST
    public int size() {
// TODO
        return -1;
    }

    // Check whether element e is in BST
    public boolean contains(BNode<E> node, E e) {
        if (root == null) {
            return false;
        }
        if (e.compareTo(root.getData()) == 0) {
            return true;
        } else if (e.compareTo(root.getData()) < 0) {
            return contains(root.getLeft(), e);
        } else {
            return contains(root.getRight(), e);
        }
    }

    // Find the minimum element in BST
    public E findMin() {
// TODO
        return null;
    }

    // Find the maximum element in BST
    public E findMax() {
// TODO
        return null;
    }

    // Remove element e from BST
    public boolean remove(E e) {
// TODO
        return false;
    }

    // get the descendants of a node
    public List<E> descendants(E data) {
// TODO
        return null;
    }

    // get the ancestors of a node
    public List<E> ancestors(E data) {
// TODO
        return null;
    }

    public BNode<E> getRoot() {
        return root;
    }
}