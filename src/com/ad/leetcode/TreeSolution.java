package com.ad.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeSolution {

    /**
     * 102. 二叉树的层序遍历
     * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ret = new ArrayList<List<Integer>>();

        if (root == null) return ret;

        //1. 根节点加入队列
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        //2。循环队列直到为空
        while(!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int levelSize = queue.size();

            for (int i = 1; i <= levelSize; i++) {

                //3. 取出头节点, 头节点出队
                TreeNode node = queue.poll();
                level.add(node.val);

                //4. 将节点的左节点入队
                if (node.left != null) queue.offer(node.left);

                //5. 将节点的右节点入队
                if (node.right != null) queue.offer(node.right);
            }
            ret.add(level);
        }
        return ret;
    }
}
