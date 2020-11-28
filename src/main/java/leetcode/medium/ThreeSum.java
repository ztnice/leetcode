package leetcode.medium;

import java.util.*;

public class ThreeSum {


    public static void main(String[] args) {
//        int[] arr = {-1,0,1,2,-1,-4};
//
//        List<List<Integer>> lists = threeSum(arr);
//
//        List<List<Integer>> lists1 = result(arr);

//        System.out.println(lists);

        int[] nums = {-3,-2,-5,3,-4};
        int i = threeSumClosest(nums,-1);
        System.out.println(i);
//        System.out.println(isAnagram1("aab","baa"));
    }

    /**
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
     * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     * @param nums
     * @return
     */

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> lists = new ArrayList<>();
        //先排序
        Arrays.sort(nums);
        for(int i = 0 ; i < nums.length; i++){
            //和上一次数据不同
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //右指针
            int k = nums.length -1 ;
            int target = -nums[i];
            for(int j = i+1 ; j < nums.length ; j++){

                //和上一次数据不同
                if(j > i + 1 && nums[j] == nums[j -1 ]){
                    continue;
                }

                // 需要保证 b 的指针在 c 的指针的左侧
                while (j < k && nums[j] + nums[k] > target) {
                    --k;
                }

                if(j == k){
                    break;
                }
                if(nums[j] + nums[k] == target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    lists.add(list);
                }
            }
        }
        return lists;
    }



    public static List<List<Integer>> result(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举 a
        for (int first = 0; first < n; ++first) {
            // 需要和上一次枚举的数不相同
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int third = n - 1;
            int target = -nums[first];
            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                // 需要和上一次枚举的数不相同
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }



    public static boolean isAnagram(String s, String t) {

        if(s.length() != t.length()){
            return false;
        }

        int[] table = new int[26];

        for(int i = 0 ; i < s.length(); i++){


            table[s.charAt(i) - 'a'] ++;
        }

        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i) - 'a']--;
            if (table[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }



    public static boolean isAnagram1(String s, String t) {

        if(s == null || t == null){
            return false;
        }
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){

            char ch = s.charAt(i);

            map.put(ch,map.getOrDefault(ch,0) + 1);
        }

        for(int i  = 0 ; i < t.length() ; i++){

            char ch = t.charAt(i);

            map.put(ch,map.getOrDefault(ch,0) -1);

            int v = map.get(ch);

            if(v < 0){
                return false;
            }
        }

        return true;

    }




    public  static int threeSumClosest(int[] nums, int target) {
        //需要记录三数之和
        int res = 10000000;
        Arrays.sort(nums);

        int n = nums.length;

        for(int i = 0 ; i < n ; i++){
            //重复遍历过的元素 直接跳过
            if(i > 0 && nums[i] == nums[i -1]){
                continue;
            }

            //使用双指针 标记
            int rb = i + 1;
            int rc = n - 1;

            while (rb < rc){
                int sum = nums[i] + nums[rb] + nums[rc];

                if(sum == target){
                    return sum;
                }

                int sumAbs = Math.abs(sum - target);
                int resAbs = Math.abs(res - target);
                if(sumAbs < resAbs){
                    res = sum;
                }

                if(sum > target){
                    // 左指针不动 右指针左移 并且跳过相等的元素

                    int rc1 = rc -1;
                    while (rb < rc1 && nums[rc1] == nums[rc]){
                        rc1 -- ;
                    }
                    rc = rc1;
                }else {

                    //右指针不动 左指针右移 并且跳过相等的元素

                    int rb1 = rb +1;
                    while (rb1 < rc && nums[rb1] == nums[rb]){
                        rb1 ++;
                    }

                    rb = rb1;

                }

            }

        }

        return res;

    }


}
