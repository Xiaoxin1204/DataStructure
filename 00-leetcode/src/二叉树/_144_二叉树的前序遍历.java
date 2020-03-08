package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
 */
public class _144_二叉树的前序遍历 {
    //递归实现
    private List<Integer> arr = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) return arr;
        arr.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return arr;
    }


    /**
     * 迭代,性能有点低
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal2(TreeNode root) {
        LinkedList<Integer> data = new LinkedList<>();

        if (root == null) return data;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root.left);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            data.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return data;
    }


}
