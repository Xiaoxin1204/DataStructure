package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 */
public class _226_翻转二叉树 {


    /**
     * 前序遍历翻转，中序，后序原理一样
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp;
        tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    /**
     * 层次遍历
     * @param root
     * @return
     */

    public TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp;
            tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return root;
    }

}
