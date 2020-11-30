package leetcode.simple;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/11/27
 */
public class RunningSum {

    //100 000 000
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(runningSum(arr)));
    }

    /**
     * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
     * 请返回 nums 的动态和。
     * @param nums
     * @return
     */
    public  static int[] runningSum(int[] nums) {
        for(int i = 1 ; i < nums.length; i++){
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
