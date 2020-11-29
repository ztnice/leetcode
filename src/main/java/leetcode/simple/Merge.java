package leetcode.simple;

import java.util.Arrays;

public class Merge {

    public static void main(String[] args) {

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

//        merge(nums1,3,nums2,3);
        merge2(nums1,3,nums2,3);
//        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }


    public  static void merge(int[] nums1, int m, int[] nums2, int n) {
        // m = 3 n = 2  len = 5
        int len  = m + n;
        int j = 0;
        for(int i = m ; i < len ; i++){
            nums1[i] = nums2[j];
            j++;
        }

        Arrays.sort(nums1);
    }


    public  static void merge1(int[] nums1, int m, int[] nums2, int n) {
        // m = 3 n = 2  len = 5

        int[] nums1Copy = new int[m];

        System.arraycopy(nums1,0,nums1Copy,0,m);

        int p1 = 0;
        int p2 = 0;
        int p = 0;
        while ((p1 < m) && (p2 < n)){
            nums1[p++] = nums1Copy[p1] < nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }

        if(p1 < m){
            System.arraycopy(nums1Copy,p1,nums1,p1+p2,m+n - p1 - p2);
        }

        if(p2 < n ){
            System.arraycopy(nums2,p2,nums1,p1+p2,m + n - p1 - p2);
        }

    }



    public  static void merge2(int[] nums1, int m, int[] nums2, int n) {
        // m = 3 n = 2  len = 5
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while ((p1 >= 0) && (p2 >= 0)){
            nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }



}
