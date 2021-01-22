package leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author haozt
 * @since 2021/1/22
 */
public class TwoSumII {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15,17,19,23,45,555,890,999,10001};
        int[] arr = twoSum(nums,1001);
//        int[] nums = {-1,0};
//        int[] arr = twoSum(nums,-1);

        int[] arr1 = twoSum1(nums,1001);
        System.out.println(Arrays.toString(arr));

        System.out.println(Arrays.toString(arr1));
    }

    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
     *
     * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
     *
     * 说明:
     *
     * 返回的下标值（index1 和 index2）不是从零开始的。
     * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
     *
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum(int[] numbers, int target) {
        //let me see
        /**
         * 是否可以使用二分查找实现呢
         *
         * 假设要查找的目标元素为 target- numbers[0]
         *
         * 如果找不到 那改变目标元素为target-numbers[1]
         *
         * 依次类推
         * numbers = [2, 7, 11, 15], target = 9
         *
         */

        int i = numbers.length -1;

        while ( numbers[i] > target &&  i > 1){
            i--;
        }
        int findNum = target - numbers[i];
        int[] res = new int[2];
        while ( i > 0){
            int left = 0 ,right = i ;
            while (left <= right){
                int middleIndex = ((right - left) >> 1) + left;
                int middle = numbers[middleIndex];
                if(middle == findNum){
                    res[0] = middleIndex + 1;
                    res[1] = i + 1;
                    return res;
                }else if(middle < findNum){
                    left = middleIndex + 1;
                }else {
                    right = middleIndex - 1;
                }
            }
            i--;
            findNum = target - numbers[i];

        }
        return res;
    }


    public static int[] twoSum1(int[] numbers, int target) {
        //let me see
        /**
         *用map实现 也可以使用双指针
         * 依次类推
         * numbers = [2, 7, 11, 15], target = 9
         *
         */

        Map<Integer,Integer> map = new HashMap<>();


        for(int i = 0 ; i < numbers.length ; i++){

            int val = target - numbers[i];
            if(map.get(val) != null){
                return new int[]{map.get(val),i + 1};
            }
            map.put(numbers[i] ,i + 1);
        }

        return new int[]{0,0};
    }
}
