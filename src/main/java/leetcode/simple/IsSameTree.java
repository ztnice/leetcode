package leetcode.simple;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haozt
 * @since 2020/11/30
 */
public class IsSameTree {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 给定两个二叉树，编写一个函数来检验它们是否相同。
     *
     * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
     * @param p
     * @param q
     * @return
     */
    //深度优先搜索
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p == null && q == null ){
            return true;
        }else if(p == null || q == null){
            return false;
        }else if(p.val != q.val){
            return false;
        }else {
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
    }


    /**
     * 广度优先搜索
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree2(TreeNode p, TreeNode q) {

        if(p == null && q == null ){
            return true;
        }else if(p == null || q == null){
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.offer(p);
        q2.offer(q);

        while (!q1.isEmpty() && !q2.isEmpty()){

            TreeNode node1 = q1.poll();
            TreeNode node2 = q2.poll();
            if(node1 == null && node2 == null ){
                return true;
            }else if(node1 == null || node2 == null){
                return false;
            }
            if(node1.val != node2.val){
                return false;
            }

            TreeNode left1 = node1.left,right1 = node1.right;
            TreeNode left2 = node2.left,right2 = node2.right;
            if (left1 == null ^ left2 == null) {
                return false;
            }
            if (right1 == null ^ right2 == null) {
                return false;
            }

            if(left1 != null){
                q1.offer(left1);
            }
            if(right1 != null){
                q1.offer(right1);
            }

            if(left2 != null){
                q2.offer(left2);
            }
            if(right2 != null){
                q2.offer(right2);
            }
        }
        return q1.isEmpty() && q2.isEmpty();
    }

}
