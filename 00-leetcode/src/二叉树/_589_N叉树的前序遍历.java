package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/
 */
public class _589_N叉树的前序遍历 {

    List<Integer> arr = new ArrayList<>();

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> preorder(Node root) {
        if (root == null) return arr;
        arr.add(root.val);
        for (Node child : root.children) {
            preorder(child);
        }
        return arr;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> preorder2(Node root) {
        LinkedList<Integer> arr = new LinkedList<>();
        if (root == null) return arr;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            arr.add(node.val);
            for (int i = node.children.size() - 1; i >= 0; i--) {
                stack.push(node.children.get(i));
            }
        }
        return arr;
    }

}
