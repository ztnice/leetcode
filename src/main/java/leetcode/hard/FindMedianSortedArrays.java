package leetcode.hard;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/10/19
 * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
 */
public class FindMedianSortedArrays {


    public static void main(String[] args) {

        int []nums1 = new int[]{3}, nums2 = new int[]{2};
        double a = findMedianSortedArrays(nums1,nums2);
        System.out.println(a);
    }

    // 1. 合并数组 2.排序 3.取出中位数
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int [] arr = new int[nums1.length + nums2.length];

        System.arraycopy(nums1,0,arr,0,nums1.length);
        System.arraycopy(nums2,0,arr,nums1.length,nums2.length);

        Arrays.sort(arr);
        int length = arr.length;
        int i = length >> 1;
        //奇数
        if((length & 1) != 0){
            return  arr[i];
        }

        int a1 = arr[i];
        int a2 = arr[i-1];
        return (a1 + a2 ) / 2.0;
    }




}
