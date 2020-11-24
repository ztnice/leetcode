package leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haozt
 * @since 2020/10/13 0013
 */
public class TwoSum {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     */


    public static void main(String[] args) {
//        int[] arr = {2, 7, 11, 15};
//        int[] result = twoNumSum1(arr,9);
//        System.out.println(Arrays.toString(result));

        System.out.println(reverse(Integer.MAX_VALUE/10));

        String str = "fajkhiuweqwe";
        System.out.println(new StringBuilder(str).reverse());



    }


    public static int[] twoNumSum(int[] nums,int target){

        for(int i = 0 ;i < nums.length; i++){

            for(int j = i + 1; j < nums.length ;j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i,j};
                }
            }
        }

        System.out.println("没有找到合适结果");
        return new int[2];

    }


    public static int[] twoNumSum1(int[] nums,int target){
        //key result value index
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < nums.length ;i++ ){
            int a = target - nums[i];
            if(map.containsKey(a) && i != map.get(a)){
                return new int[]{i,map.get(a)};
            }
            map.put(nums[i] ,i);

        }
        System.out.println("没有找到合适结果");
        return new int[2];

    }




    //数字反转  123 -> 321   120 -> 21
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0){
            int n = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE  / 10 ) {
                return 0;
            }
            if (reverse < Integer.MIN_VALUE / 10 ) {
                return 0;
            }
            reverse = reverse * 10 + n;
        }

        return reverse;
    }



}
