package leetcode.simple;

import java.util.Arrays;

public class RemoveDuplicates {


    public static void main(String[] args) {

        int[] arr = {1,1,1,1,1,1,1};

        int[] arr1 = {0,0,0,1,1,1,1,1,2,3,4,5,5,6};

        int[] arr2 = {1,2,3,4,5};
        int n = removeDuplicates1(arr1);

        System.out.println(n + ":" + Arrays.toString(arr1));
    }


    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。

     不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * @param nums
     * @return
     */

    //傻子 傻子 还是没有理解到精髓
    public static int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int n = nums[0];
        if(n == nums[nums.length -1 ]){
            return 1;
        }
        int left = 1,right = 1;
        boolean swap = false;
        while (right < nums.length){
            if(n == nums[right]){
                swap = true;
                //需要记录i 然后找到不相等的 替换i的位置
                right ++;
            }else {
                //进行交换
                if(swap){
                    swap(nums,right,left);
                }
                n = nums[left];
                left ++;
                right++;
            }

        }

        return left;

    }



    public static int removeDuplicates1(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        if(nums[0] == nums[nums.length - 1]){
            return 1;
        }

        int i = 0 ;

        for(int j = 1 ; j < nums.length ; j++){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }

        }

        return i + 1;
    }


    public static void swap(int[] arr,int a,int b ){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
