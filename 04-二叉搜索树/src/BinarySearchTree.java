import printer.BinaryTreeInfo;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<E> implements BinaryTreeInfo {
    private int size = 0;
    private Node<E> root;
    private Comparator<E> comparator;

    public BinarySearchTree(Comparator<E> comparator) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {

    }
    /**
     * 查找后继节点
     * @param node
     * @return
     */
    public Node<E> successor(Node<E> node) {
        if (node == null) return null;
        Node<E> p = node.right;
        if (p != null) {
            while (p.left != null) {
                p = p.left;
            }
            return p;
        }

        while (node.parent != null && node == node.parent.right) {
            node = node.parent;
        }
        return node.parent;

    }

    /**
     * 查找前驱节点
     * @param node
     * @return
     */
    public Node<E> predecessor(Node<E> node) {
        if (node == null) return null;
        Node<E> p = node.left;
        if (p != null) {
            while (p.right != null) {
                p = p.right;
            }
            return p;
        }

        while (node.parent != null && node == node.parent.left) {
            node = node.parent;
        }
        return node.parent;

    }
    /**
     * 判断是否是完全二叉树
     * @return
     */
    public boolean isComplete() {
        if (root == null) return false;
        Queue<Node<E>> queue = new LinkedList<>();
        boolean leaf = false;
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            if (leaf && !n.isLeaf()) {
                return false;
            }
            if (n.left != null) {
                queue.offer(n.left);
            } else if (n.right != null) {
                return false;
            }

            if (n.right != null) {
                queue.offer(n.right);
            }else {
                leaf = true;
            }
        }
        return true;
    }

    public int height() {
        return height(root);
    }

    /**
     * 迭代实现
     *
     * @return
     */
    private int height(Node<E> root) {
        int height = 0;
        int levelSize = 1;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            levelSize--;
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }
            if (levelSize == 0) {
                height++;
                levelSize = queue.size();
            }
        }
        return height;

    }

    /**
     * 递归实现
     *
     * @param
     * @return
     */
   /* private int height(Node<E> node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left),height(node.right));
    }*/
    @Override
    public Object root() {
        return root;
    }

    @Override
    public Object left(Object node) {
        return ((Node<E>) node).left;
    }

    @Override
    public Object right(Object node) {
        return ((Node<E>) node).right;
    }

    @Override
    public Object string(Object node) {
        return ((Node<E>) node).element;
    }

    public static interface Visitor<E> {
        void visit(E element);
    }

    public void preOrderTraversal(Visitor<E> visitor) {
        preOrderTraversal(root, visitor);
    }

    private void preOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        visitor.visit(node.element);
        preOrderTraversal(node.left, visitor);
        preOrderTraversal(node.right, visitor);
    }

    public void inOrderTraversal(Visitor<E> visitor) {
        inOrderTraversal(root, visitor);
    }

    private void inOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        inOrderTraversal(node.left, visitor);
        visitor.visit(node.element);
        inOrderTraversal(node.right, visitor);
    }

    public void postOrderTraversal(Visitor<E> visitor) {
        postOrderTraversal(root, visitor);
    }

    private void postOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        postOrderTraversal(node.left, visitor);
        postOrderTraversal(node.right, visitor);
        visitor.visit(node.element);
    }

    public void levelOrderTraversal(Visitor<E> visitor) {
        levelOrderTraversal(root, visitor);
    }

    private void levelOrderTraversal(Node<E> node, Visitor<E> visitor) {
        if (node == null || visitor == null) return;
        Queue<Node<E>> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node<E> n = queue.poll();
            visitor.visit(n.element);
            if (n.left != null) {
                queue.offer(n.left);
            }
            if (n.right != null) {
                queue.offer(n.right);
            }

        }
    }


    /*  private void preOrderTraversal(Node<E> node) {
          if (node == null) return;
          System.out.println(node.element);
          preOrderTraversal(node.left);
          preOrderTraversal(node.right);

      }*/
    private static class Node<E> {
        E element;
        Node<E> right;
        Node<E> left;
        Node<E> parent;

        public Node(E element, Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }

        public boolean hasTwoChildren() {
            return left != null && right != null;
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
                node.element = element;
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
        if (comparator != null) {
            return comparator.compare(element1, element2);
        }
        return ((Comparable<E>) element1).compareTo(element2);
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


