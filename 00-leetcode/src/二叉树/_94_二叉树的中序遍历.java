package 二叉树;

import javax.crypto.spec.RC2ParameterSpec;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/
 */
public class _94_二叉树的中序遍历 {

    private List<Integer> arr = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return arr;

        inorderTraversal(root.left);
        arr.add(root.val);
        inorderTraversal(root.right);
        return arr;
    }

    /**
     * 迭代
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        LinkedList<Integer> put = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;

        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            put.add(curr.val);
            curr = curr.right;
        }

        return put;
    }

}
