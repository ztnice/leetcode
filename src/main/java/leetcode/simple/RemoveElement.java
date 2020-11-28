package leetcode.simple;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int[] arr2 = {3,2,2,3,2,2,2,2,2,2,3,3};
        int[] arr3 = {1,1};
        int[] arr4 = {1,2,3,2,4,6,7,2,2,2,1,5};
        int[] arr5 = {2,3,4,1,2,3,4,5,3,2,4,5,6};
//
        int n = removeElement1(arr2,3);
        System.out.println(n + ":" + Arrays.toString(arr2));
        int n1 = removeElement(arr3,1);
        System.out.println(n1 + ":" + Arrays.toString(arr3));
        int n2 = removeElement(arr4,2);
        System.out.println(n2 + ":" + Arrays.toString(arr4));
        int n3 = removeElement(arr5,3);
        System.out.println(n3 + ":" + Arrays.toString(arr5));
        int n4 = removeElement(arr,2);
        System.out.println(n4 + ":" + Arrays.toString(arr));


    }


    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。

     不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。

     元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {

        //1 2 3 4 5      3
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 1 ; j < nums.length ; j++){
            if(nums[i] == val){
                while (nums[i] == nums[j]){
                    j++;
                    if(j == nums.length){
                        return i;
                    }
                }
                swap(nums,i,j);
            }
            i++;
        }


        int count = 0;
        for(int j = nums.length -1 ; j >= 0 ; j--){
            if(nums[j] == val){
                count ++;
            }
        }


        return  nums.length - count ;
    }



    public static int removeElement1(int[] nums, int val) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int i = 0;
        for(int j = 0 ; j < nums.length ; j++){
            if(nums[j] != val ){
                nums[i] = nums[j];
                i++;
            }
        }

        return i;

    }


    public static int removeElement2(int[] nums, int val) {

        int n = nums.length;

        int i = 0;

        while (i < n ){
            if(nums[i] != val){
                i++;
                continue;
            }
            nums[i] = nums[n-1];
            n -- ;
        }

        return n;

    }
    public static void swap(int[] arr,int a,int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
