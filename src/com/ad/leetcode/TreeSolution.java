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

    /**
     * 104. 二叉树的最大深度
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     *
     * 递归求最大深度
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {

        int ans = 0;
        if (root == null) return ans;

        //递归 求左右子树的最大深度 +1
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 104. 二叉树的最大深度
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     *
     * 层序遍历求最大深度
     * @param root
     * @return
     */
    public int maxDepth1(TreeNode root) {
        int ans = 0;
        if (root == null) return ans;

        //声明队列
        Queue<TreeNode> q = new LinkedList<>();

        //根节点放入队列
        q.offer(root);

        //队列不为空，遍历节点
        while(!q.isEmpty()) {

            //获取队列的长度
            int size = q.size();

            //当前层，队列中的所有数据
            while(size > 0) {

                //节点出队
                TreeNode node = q.poll();

                //出队节点，如果左子树有数据，放入队列
                if (node.left != null) {
                    q.offer(node.left);
                }

                //出队节点，如果右子树有数据，放入队列
                if (node.right != null) {
                    q.offer(node.right);
                }

                //读取完数据，队列size-1
                size--;
            }

            //循环一层，将层数+1
            ans++;
        }

        return ans;
    }

    /**
     * 144. 二叉树的前序遍历
     * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     *
     * 前序遍历:先遍历中间加点 ，然后左子树，最后右子树
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        preorder(root, ans);
        return ans;
    }

    private void preorder(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        ans.add(root.val);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }
}
