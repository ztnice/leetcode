package leetcode.simple;

import leetcode.base.structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class IsSymmetric {

    public static void main(String[] args) {

    }

    /**
     * 给定一个二叉树，检查它是否是镜像对称的
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。

               1
             /   \
             2   2
            / \ / \
           3  4 4  3
     */



    //维护两个指针 p(left) q(right)  p左 q右 判断两个指针的值是不是一致 就完事 递归实现
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return check(root.left,root.right);

    }

    public boolean check(TreeNode left,TreeNode right) {

        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && check(left.left,right.right) && check(left.right,right.left);


    }




    //遍历 维护队列实现 非递归方式
    public boolean isSymmetric1(TreeNode root) {
        if(root == null){
            return true;
        }
        return check1(root.left,root.right);

    }

    public boolean check1(TreeNode left,TreeNode right) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(left);
        queue.offer(right);
        while (!queue.isEmpty()){

            left = queue.poll();
            right = queue.poll();

            if(left == null && right == null){

                continue;
            }

            if((left == null || right == null ) || left.val != right.val ){
                return false;
            }


            queue.offer(left.left);
            queue.offer(right.right);
            queue.offer(left.right);
            queue.offer(right.left);
        }

        return true;
    }


}
