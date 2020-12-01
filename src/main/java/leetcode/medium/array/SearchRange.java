package leetcode.medium.array;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/12/1
 */
public class SearchRange {

    public static void main(String[] args) {
        int[] arr = {1,2,8,8,9,10};
        int[] arr1 = searchRange1(arr,8);
        int[] arr2 = searchRange(arr,8);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

    }


    /**
     *给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     *
     * 如果数组中不存在目标值 target，返回 [-1, -1]。
     *
     */
    public  static int[] searchRange(int[] nums, int target) {
        //应该可以使用二分法 时间复杂度度低
        int[] res = new int[2];
        int left = -1,right = -1;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > target){
                break;
            }
            if(nums[i] == target){
                if(left == -1){
                    left = i;
                }else {
                    right = i;
                }
            }
        }

        res[0] = left;
        res[1] = right == -1 ? left : right;
        return res;
    }




    //使用二分法
    public  static int[] searchRange1(int[] nums, int target) {

        int[] res = {-1,-1};

        int left = 0,left0 = -1,right0 = -1 ,right = nums.length -1;

        while (left <= right){
            int mid = ((right - left) >> 1) + left;
            int num = nums[mid];
            if(num == target){
                left0 = mid;
                right0 = mid;

                int mid1 = mid;
                //这块修改一下
                while (mid >= 1 ){
                    mid --;
                    if( nums[mid] != target){
                        break;
                    }
                    left0 = mid;
                }
                while (mid1 <= right -1 ){
                    mid1 ++;
                    if(nums[mid1] != target){
                        break;
                    }
                    right0 = mid1;
                }
                break;
            }else if(nums[mid] < target){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }

        if(left0 != -1 ){
            res[0] = left0;
            res[1] = right0;
        }
        return res;
    }
}
