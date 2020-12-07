package leetcode.medium.tanxin;

/**
 * @author haozt
 * @since 2020/12/7
 */
public class MatrixScore {

    public static void main(String[] args) {

    }


    /**
     * 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
     *
     * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
     *
     * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
     *
     * 返回尽可能高的分数。
     *
     *  
     *
     * 示例：
     *
     * 输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
     * 输出：39
     * 解释：
     * 转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
     * 0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
     *
     * @param A
     * @return
     */
    public int matrixScore(int[][] A) {
        int m = A.length;//行
        int n = A[0].length;//列
        //最左侧都是1
        int ret = m * ( 1 << ( n - 1 )); //m * 2^(n-1)

        for(int j = 1; j < n; j++){
            int nOnes = 0;
            for(int i = 0; i < m ; i++){

                if(A[i][0] == 1){
                    nOnes += A[i][j];
                }else {
                    nOnes += (1 - A[i][j]);
                }

            }

            int k = Math.max(nOnes,m - nOnes);
            ret += k*(1 << (n - j - 1));
        }

        return ret;

    }

}
