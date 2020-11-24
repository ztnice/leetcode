package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author haozt
 * @since 2020/10/29
 */
public class TreeNode {
    int val;

    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(4);
        TreeNode treeNode1 = new TreeNode(9);
        TreeNode treeNode2 = new TreeNode(5);
        TreeNode treeNode3 = new TreeNode(0);
        TreeNode treeNode4 = new TreeNode(1);

        treeNode.left = treeNode1;
        treeNode.right = treeNode3;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode4;

        System.out.println(new TreeNode().new Solution().sumNumbers1(treeNode));
    }

    class Solution {
        /**
         * 给定一个二叉树，它的每个结点都存放一个 0-9 的数字，每条从根到叶子节点的路径都代表一个数字。
         *
         * 例如，从根到叶子节点路径 1->2->3 代表数字 123。
         *
         * 计算从根到叶子节点生成的所有数字之和。
         *
         * 说明: 叶子节点是指没有子节点的节点。
         * @return
         */

        //广度搜索
        public int sumNumbers1(TreeNode root) {
            int sum = 0;
            if(root == null){
                return sum;
            }
            Queue<TreeNode> nodeQueue = new LinkedList<>();
            Queue<Integer> numQueue = new LinkedList<>();
            nodeQueue.offer(root);
            numQueue.offer(root.val);

            while (!nodeQueue.isEmpty()){
                TreeNode node = nodeQueue.poll();
                TreeNode left = node.left;
                TreeNode right  = node.right;
                int num = numQueue.poll();
                if(left == null && right == null){
                    sum += num;
                }else {
                    if(left != null){
                        numQueue.offer(num * 10 + left.val);
                        nodeQueue.offer(left);
                    }
                    if(right != null){
                        numQueue.offer(num * 10 + right.val);
                        nodeQueue.offer(right);
                    }
                }
            }
            return sum;

        }


        //深度搜索
        public int sumNumbers(TreeNode root) {
            return dfs(root,0);
        }

        public int dfs (TreeNode node , int pre){
            if(node == null){
                return 0;
            }

            int sum  = pre * 10 + node.val;
            if(node.left == null && node.right == null){
                return sum;
            }else {
               return dfs(node.left,sum) + dfs(node.right,sum);
            }
        }

    }
}
