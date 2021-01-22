package leetcode.medium.动态规划;

/**
 * @author haozt
 * @since 2020/12/9
 */
public class UniquePaths {


    public static void main(String[] args) {
        int n = uniquePaths(3,7);
        System.out.println(n);
    }


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     * @param m
     * @param n
     * @return
     */


    /**
     * 方法一：动态规划
     * 思路与算法
     *
     * 我们用 f(i, j)f(i,j) 表示从左上角走到 (i, j)(i,j) 的路径数量，其中 ii 和 jj 的范围分别是 [0, m)[0,m) 和 [0, n)[0,n)。
     *
     * 由于我们每一步只能从向下或者向右移动一步，因此要想走到 (i, j)(i,j)，如果向下走一步，那么会从 (i-1, j)(i−1,j) 走过来；如果向右走一步，那么会从 (i, j-1)(i,j−1) 走过来。因此我们可以写出动态规划转移方程：
     *
     * f(i, j) = f(i-1, j) + f(i, j-1)
     * f(i,j)=f(i−1,j)+f(i,j−1)
     *
     * 需要注意的是，如果 i=0i=0，那么 f(i-1,j)f(i−1,j) 并不是一个满足要求的状态，我们需要忽略这一项；同理，如果 j=0j=0，那么 f(i,j-1)f(i,j−1) 并不是一个满足要求的状态，我们需要忽略这一项。
     *
     * 初始条件为 f(0,0)=1f(0,0)=1，即从左上角走到左上角有一种方法。
     *
     * 最终的答案即为 f(m-1,n-1)f(m−1,n−1)。
     *
     * 细节
     *
     * 为了方便代码编写，我们可以将所有的 f(0, j)f(0,j) 以及 f(i, 0)f(i,0) 都设置为边界条件，它们的值均为 11。
     * @param m
     * @param n
     * @return
     */
    public static int uniquePaths(int m, int n) {

        int[][] f = new int[m][n];

        for(int i = 0 ; i < m ; i++){
            f[i][0] = 1;
        }

        for(int i = 0 ; i < n ; i++){
            f[0][i] = 1;
        }


        for(int i = 1; i < m ; i++){
            for(int j = 1 ; j < n; j++){
                f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][ n -1];
    }


    /**
     * 排列组合解法
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths1(int m, int n) {
        long ans = 1;
        for (int x = n, y = 1; y < m; ++x, ++y) {
            ans = ans * x / y;
        }
        return (int) ans;
    }

}
