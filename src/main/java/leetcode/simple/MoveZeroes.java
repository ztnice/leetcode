package leetcode.simple;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/11/19
 */
public class MoveZeroes {

    public static void main(String[] args) {
        int[] arr = new int[]{2,1};
        //1 3  12 0000
        moveZeroes1(arr);
    }


    /**
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     *
        1.必须在原数组上操作，不能拷贝额外的数组。
        2.尽量减少操作次数。
        输入: [0,1,0,3,12]
        输出: [1,3,12,0,0]
     * @param nums
     */
    public static void moveZeroes(int[] nums) {

        int right = nums.length-1;

        int left = 0;
        while (left < nums.length){
            if(nums[left] != 0 ){
                left++;
                continue;
            }
            if(left >= right){
                break;
            }

            int temp = nums[left];
            //前面全部元素 都进行移位
            for(int j = left ; j < right ; j++){
                nums[j] = nums[j+1];
            }
            nums[right] = temp;
            right--;
        }

        System.out.println(Arrays.toString(nums));



    }



    public static void moveZeroes1(int[] nums) {

        int right = 0 ,left = 0;
        while (right < nums.length){
            if(nums[right] != 0){
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            right++;

        }

        System.out.println(Arrays.toString(nums));



    }
}
