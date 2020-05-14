package 二叉树;


import java.util.*;

/**
 * https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal/
 */
public class _590_N叉树的后序遍历 {
    List<Integer> arr = new ArrayList<>();

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> postorder(Node root) {
        if (root == null) return arr;
        for (Node child : root.children) {
            postorder(child);
        }
        arr.add(root.val);
        return arr;
    }



    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public List<Integer> postorder2(Node root) {
        if (root == null) return arr;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        Node node = null;
        while (!stack.isEmpty()) {
            node = stack.pop();
            arr.add(node.val);
            for (int i = 0; i < node.children.size(); i++) {
                stack.push(node.children.get(i));
            }
        }
        Collections.reverse(arr);
        return arr;
    }


}
