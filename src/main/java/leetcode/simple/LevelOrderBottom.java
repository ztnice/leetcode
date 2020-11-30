package leetcode.simple;

import leetcode.base.structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LevelOrderBottom {


    public static void main(String[] args) {
        TreeNode node = new TreeNode(3,new TreeNode(9),new TreeNode(20,new TreeNode(15),new TreeNode(7)));

        List<List<Integer>> lists = levelOrderBottom(node);
        System.out.println(lists);
    }

    /**
     * 给定一个二叉树，返回其节点值自底向上的层次遍历。
     * （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     *
     * 例如：
     给定二叉树 [3,9,20,null,null,15,7],

     3
     / \
     9  20
       /  \
      15   7
     返回其自底向上的层次遍历为：

     [
     [15,7],
     [9,20],
     [3]
     ]

     */


    public static List<List<Integer>> levelOrderBottom(TreeNode root) {

        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        l.add(list);
        List<List<Integer>> lists = resultList(l,root);


        Collections.reverse(lists);

        return lists;



    }


    public  static List<List<Integer>>  resultList(List<List<Integer>> lists , TreeNode treeNode){

        if(treeNode == null){
            return lists;
        }

        List<Integer> list = new ArrayList<>();
        if(treeNode.left != null){
            list.add(treeNode.left.val);
        }
        if(treeNode.right != null){
            list.add(treeNode.right.val);
        }
        if(!list.isEmpty()){
            lists.add(list);
        }
        resultList(lists,treeNode.left) ;

        resultList(lists,treeNode.right) ;
        return lists;

    }
}
