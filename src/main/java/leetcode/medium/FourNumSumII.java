package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozt
 * @since 2020/11/27
 */
public class FourNumSumII {

    public static void main(String[] args) {
        int[] A = { 1, 2};
        int[] B = {-2,-1};
        int[] C = {-1, 2};
        int[] D = { 0, 2};

        int res = fourSumCount(A,B,C,D);
        System.out.println(res);

    }

    /**
     * 四数相加 II
     * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
     *
     * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
     * @param A
     * @param B
     * @param C
     * @param D
     * @return
     */
    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {


        //两两分组 A B 为一组  C D 为一组 求和看是否为0 这样时间复杂度为O(n^2)
        // key A[i]+B[j]  value 次数
        Map<Integer,Integer> map = new HashMap<>();

        int res = 0;
        for(int i = 0 ; i < A.length; i++){
            for(int j = 0 ; j < B.length ;j++){
                int sum = A[i]+B[j];
                map.put(sum,(map.getOrDefault(sum,0) + 1));
            }
        }

        //a + b + c + d = 0   a+b = -(c+d)
        for(int i = 0 ; i < C.length; i++){
            for(int j = 0 ; j < D.length; j++){
                int sum = -(C[i] + D[j]);
                if(map.containsKey(sum)){
                    res +=map.get(sum);
                }
            }
        }

        return res;
    }

}
