package leetcode.simple;

public class SearchInsert {

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(searchInsert(arr,0));
        System.out.println(searchInsert1(arr,0));
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。

     你可以假设数组中无重复元素。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {

        if(nums == null){
            return 0;
        }

        int i = 0;
        for( ; i < nums.length ; i++){

            if(nums[i] >= target){
                return i;
            }

        }

        return i;

    }


    //来来来 二分法 草
    public static int searchInsert1(int[] nums, int target) {

        if(nums == null){
            return 0;
        }

        int left = 0, right = nums.length -1,n = nums.length;

        if(target > nums[right]){
            return n;
        }
        while (left <= right){

            int mid = ((right - left) >> 1) + left;

            if(nums[mid] >= target){

                right = mid -1;
                n = mid;
                continue;
            }

            left  = mid + 1 ;
        }

        return n;
    }

}
