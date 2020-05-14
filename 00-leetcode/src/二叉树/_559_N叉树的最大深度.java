package 二叉树;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/
 */
public class _559_N叉树的最大深度 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(Node root) {
        if (root == null) return 0;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    /**
     * 迭代
     *
     * @param root
     * @return
     */
    public int maxDepth2(Node root) {
        if (root == null) return 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int levelSize = 1;
        int depth = 0;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            levelSize--;
            if (node.children != null) {
                for (Node child : node.children) {
                    queue.offer(child);
                }
            }
            if (levelSize == 0) {
                depth++;
                levelSize = queue.size();
            }

        }
        return depth;
    }
}
