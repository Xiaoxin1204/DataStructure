import java.security.PublicKey;

public class BinarySearchTree<E> {
    private int size = 0;
    private Node<E> root;

    private static class Node<E> {
        E element;
        Node<E> right;
        Node<E> left;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }
    }

    public void add(E element) {
        elementNotNullCheck(element);
        //插入根节点
        if (root == null) {
            root = new Node<>(element, null);
            size++;
            return;
        }

        //插入后续节点
        Node<E> parent = root;
        Node<E> node = root;
        int compare = 0;
        while (node != null) {
            compare = compare(element, node.element);
            parent = node;
            if (compare > 0) {
                node = node.right;
            } else if (compare < 0) {
                node = node.left;
            } else {
                return;
            }
        }
        Node<E> newNode = new Node<>(element, parent);
        if (compare > 0) {
            parent.right = newNode;
        } else {
            parent.left = newNode;
        }
        size++;

    }

    private void elementNotNullCheck(E element) {
        if (element == null) {
            throw new IllegalArgumentException("参数不能为空");
        }

    }

    public int compare(E element1, E element2) {
        return 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {

    }

    public void remove(E element) {

    }


    public boolean contains(E element) {
        return true;
    }

}


