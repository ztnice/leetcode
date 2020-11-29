package leetcode.simple;

import java.util.Arrays;

public class LargestPerimeter {

    public static void main(String[] args) {

        int[] arr = {2,1,2};
        int[] arr1 = {1,2,1};
        int[] arr2 = {3,2,3,4};
        int[] arr3 = {3,6,2,3};

        System.out.println(largestPerimeter(arr));
        System.out.println(largestPerimeter(arr1));
        System.out.println(largestPerimeter(arr2));
        System.out.println(largestPerimeter(arr3));


    }


    /**
     * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

     如果不能形成任何面积不为零的三角形，返回 0。
     * @param A
     * @return
     */
    public static int largestPerimeter(int[] A) {

        //先排序 满足 a<=b<=c 如果 a+b>c 则表示可以组成三角形

        Arrays.sort(A);
        for(int i = A.length -1 ; i >= 2; i--){

            if (A[i -1 ] + A[i - 2] > A[i]) {
                return A[i -1 ] + A[i - 2] + A[i];
            }

        }

        return 0;

    }





}
