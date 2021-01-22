package leetcode.simple;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozt
 * @since 2021/1/22 0022
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {3,3,4};
        System.out.println(majorityElement(arr));
    }

    /**
     * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
     *
     * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {

        int n = nums.length >> 1;
        Map<Integer,Integer> map = new HashMap<>();
        int num = nums[0];
        for(int i = 0 ; i < nums.length ; i++){
            Integer val = map.get(nums[i]);
            val = val == null ? 1 : val + 1;
            if(val > n){
                num = nums[i];
                break;
            }
            map.put(nums[i],val);
        }
        return num;
    }


    /**
     * 摩尔投票算法  好屌的样子
     * @param nums
     * @return
     */
    public static int majorityElement1(int[] nums) {

        int count = 0;
        int candidate = nums[0];
        for(int num : nums){
            if(count == 0){
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
