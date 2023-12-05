import java.util.ArrayList;
import java.util.List;

public class BNode<E extends Comparable<E>> {
    private E data;
    private BNode<E> left;
    private BNode<E> right;

    public BNode(E data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public BNode(E data, BNode<E> left, BNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public E getData() {
        return data;
    }

    public BNode<E> getLeft() {
        return left;
    }

    public BNode<E> getRight() {
        return right;
    }


    public void setLeft(BNode<E> left) {
        this.left = left;
    }

    public void setRight(BNode<E> right) {

        this.right = right;
    }

    public void add(E e) {
        BNode<E> value = new BNode<>(e);
        BNode<E> temp = this;
        while (true) {
            if (e.compareTo(temp.data) > 0) {
                if (temp.right == null) {
                    temp.setRight(value);
                    break;
                } else {
                    temp = temp.right;
                }
            } else {
                if (temp.left == null) {
                    temp.setLeft(value);
                    break;
                } else {
                    temp = temp.left;
                }
            }
        }
    }

    public int depth(E node) {
        int comp = node.compareTo(data);
        if (comp < 0) {
            if (left == null) {
                return 0;
            } else {
                return 1 + left.depth(node);
            }
        } else if (comp == 0) {
            return 0;
        } else {
            if (this.right == null) {
                return 0;
            } else {
                return 1 + right.depth(node);
            }
        }
    }

    public int height() {
        if (left == null && right == null) {
            return 0;
        }
        int leftHeight = 0;
        int rightHeight = 0;
        if (left != null) {
            leftHeight = left.height();
        }
        if (right != null) {
            rightHeight = right.height();
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean contains(E e) {
        int comp = e.compareTo(data);
        if (comp == 0) {
            return true;
        } else if (comp < 0) {
            return left != null && left.contains(e);
        } else {
            return right != null && right.contains(e);
        }
    }

    public int size() {
        int size = 1;
        if (left != null) {
            size += left.size();
        }
        if (right != null) {
            size += right.size();
        }
        return size;
    }

    public List<E> descendants(E e) {
        int comp = e.compareTo(data);
        List<E> list = new ArrayList<>();
        if (comp == 0) {
            if (left != null) {
                list.add(left.data);
                list.addAll(left.descendants(left.data));
            }
            if (right != null) {
                list.add(right.data);
                list.addAll(right.descendants(right.data));
            }
        } else {
            if (left.contains(e)) {
                return left.descendants(e);
            }
            if (right.contains(e)) {
                return right.descendants(e);
            }
        }
        return list;
    }

    public List<E> ancestors(E e) {
        int comp = e.compareTo(data);
        List<E> result = new ArrayList<>();
        if (comp == 0) {
            return result;
        }
        if (left != null) {
            if (left.contains(e)) {
                result.addAll(left.ancestors(e));
                result.add(data);
            }
        }
        if (right != null) {
            if (right.contains(e)) {
                result.addAll(right.ancestors(e));
                result.add(data);
            }
        }
        return result;
    }

    public E findMin() {
        return findMinHelper().data;
    }

    public E findMax() {
        return right == null ? data : right.findMax();
    }

    // Remove element e from BST
    public boolean remove(E e) {
        int comp = e.compareTo(data);
        if (comp < 0) {
            return left.remove(e);
        } else if (comp > 0) {
            return right.remove(e);
        } else {
            if (left == null) {
                return right.remove(e);
            } else if (right == null) {
                return left.remove(e);
            } else {
                BNode<E> succParent = this;
                BNode<E> succ = right;
                while (succ.left != null) {
                    succParent = succ;
                    succ = succ.left;
                }
                if (succParent != this)
                    succParent.left = succ.right;
                else
                    succParent.right = succ.right;
                data = succ.data;
                return true;
            }

        }
    }

    public BNode<E> findMinHelper() {
        if (left == null) {
            return this;
        }
        return left.findMinHelper();
    }

    public void inorder() {
        if (data == null) {
            return;
        }
        if (left != null) {
            left.inorder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.inorder();
        }
    }

    public void preorder() {
        System.out.print(data + " ");
        if (left != null) {
            left.preorder();
        }
        if (right != null) {
            right.preorder();
        }
    }

    public void postorder() {
        if (left != null) {
            left.postorder();
        }
        if (right != null) {
            right.postorder();
        }
        System.out.print(data + " ");
    }
}
