package leetcode.simple;

public class ClimbStairs {


    public static void main(String[] args) {
        System.out.println(climbStairs(16));//1836311903
        //1,1  2,2  3,3  4,5  5,8  6,13 7,21 8,33
        System.out.println(climbStairs1(16));


        System.out.println(climbStairs2(16));

    }


    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

     每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

     注意：给定 n 是一个正整数。
     * @param n
     * @return
     */
    public static int climbStairs(int n) {

        if(n == 1){
            return 1;
        }

        if(n ==2){
            return 2;
        }
        return climbStairs(n -1) + climbStairs(n - 2);

    }

    public static int climbStairs1(int n) {
        if(n == 1){
            return 1;
        }
        if(n ==2){
            return 2;
        }
        int sum = 0;
        int[] arr = new int[n];
        arr[0] = 1; arr[1] = 2;
        for(int i = 2 ; i < n ; i ++){
            arr[i] = arr[i-1]+ arr[i -2];
            sum = arr[i];
        }
        return sum;
    }


    public static int climbStairs2(int n) {

        int p = 0 , q = 0 , r = 1 ;
        for(int i = 1 ; i <= n ; i++){
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }

}
