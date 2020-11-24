package leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haozt
 * @since 2020/11/23
 */
public class FourNumSum {

    public static void main(String[] args) {

        int[] arr = {0,4,-5,2,-2,4,2,-1,4};
        List<List<Integer>> lists = fourSum(arr,12);
        System.out.println(lists);
    }

    /**
     * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
     * 注意：
     * 答案中不可以包含重复的四元组。
     * @param target
     * @return
     */

    //排序 + 双指针
    public static List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> lists = new ArrayList<>();

        if (nums == null || nums.length < 4) {
            return lists;
        }

        //先排序
        Arrays.sort(nums);

        int n = nums.length;
        // -1 0 0 1   -1 -1 -1  3
        for(int i = 0 ; i < n - 3  ; i++){
            //遍历过的 忽略  题目中说不能包含重复的四元组。
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            //a + b + c + d  = target
            if(nums[i] + nums[i+1] + nums[i+2] + nums[i + 3] > target){
                break;
            }

            if(nums[i] + nums[n - 3] + nums[n - 2] + nums[n -1] < target){
                continue;
            }

            for(int j = i + 1; j < n - 2; j++){
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if(nums[i]+ nums[j] + nums[j+1] + nums[j+2] > target){
                    break;
                }
                if(nums[i] + nums[j] + nums[n-2] + nums[n-1] < target){
                    continue;
                }


                int left = j+1,right = n-1;
                while (left < right){

                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(sum == target){
                        lists.add(addData(nums[i],nums[j],nums[left],nums[right]));
                        while (left < right && nums[left] == nums[left + 1]){
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right -1 ]){
                            right -- ;
                        }
                        right--;
                    } else  if(sum > target){
                        right -- ;
                    }else {
                        left ++;
                    }
                }
            }
        }

        return lists;

    }


    private static List<Integer> addData(int a,int b,int c,int d){

        List<Integer> list = new ArrayList<>();
        list.add(a);
        list.add(b);
        list.add(c);
        list.add(d);
        return list;
    }


}
