package leetcode.simple;

import leetcode.base.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepth {

    public static void main(String[] args) {

        TreeNode node = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));

        int i = maxDepth1(node);

        System.out.println(i);
    }


    /**
     * 给定一个二叉树，找出其最大深度。

     二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

     说明: 叶子节点是指没有子节点的节点。
     * @param root
     * @return
     */


    //深度优先解法
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = getMaxDepth(root.left,1);
        int right = getMaxDepth(root.right,1);

        return Math.max(left,right);

    }


    public static int getMaxDepth(TreeNode node,int max) {

        while (node != null){
            max++;
            return Math.max(getMaxDepth(node.left,max),getMaxDepth(node.right,max)) ;
        }
        return max;

    }




    //广度优先解法
    public static int maxDepth1(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size > 0){

                TreeNode node =  queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                }
                if(node.right != null){
                    queue.offer(node.right);
                }

                size--;
            }
            ans ++;

        }

        return ans;
    }


}
