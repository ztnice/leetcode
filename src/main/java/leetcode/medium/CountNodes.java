package leetcode.medium;

/**
 * @author haozt
 * @since 2020/11/24
 */
public class CountNodes {


    public static void main(String[] args) {

        /**
         * 输入:
         *     1
         *    / \
         *   2   3
         *  / \  /
         * 4  5 6
         */

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node2.left = node4;
        node1.right  = node3;
        node2.right = node5;
        node3.left = node6;

//        int count = countNodes(node1);
        int count = countNodes1(node1);
        System.out.println(count);



    }





    /**
     * 给出一个完全二叉树，求出该树的节点个数。
     */

    //使用二分法 + 位运算
    public static int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int level = 0;
        TreeNode node = root;
        while (node.left != null){
            level ++;
            node = node.left;
        }

        int low = 1 << level;
        int high = (1 << (1 + level)) - 1;
        while (low < high){
            int middle = (( high - low + 1 ) >> 1 ) + low;
            boolean exist = exist(root,level,middle);
            if(exist){
                low = middle;
            }else {
                high = middle - 1;
            }
        }
        return low;
    }



    // 高 实在是高  剖析的贼特么到位
    public static boolean exist(TreeNode node , int level, int k){
        //从跟节点(node)开始 往下寻找到指定节点（k）的路径

        // k-1 层
        int bits = 1 << (level - 1);//010  110  101
        TreeNode root = node;
        while (root != null && bits > 0){
            //如果K是左子节点 则k的二进制 末尾肯定是0  如果是右子节点则二进制末尾是1
            //左子节点 和 bits 按位与运算必定是0
            if((bits & k) == 0){
                root = root.left;
            }else {
                root = root.right;
            }
            //k - 2 层  k - 3 层 ... k-n 层
            bits  >>= 1;
        }

        return root != null;

    }
    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public  static int countNodes1(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = countNodes1(root.left);
        int right = countNodes1(root.right);

        return left + right + 1;

    }

}
