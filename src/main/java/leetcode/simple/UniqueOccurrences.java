package leetcode.simple;

import java.util.*;

/**
 * @author haozt
 * @since 2020/10/28
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 *
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 */
public class UniqueOccurrences {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1,1,3};
        System.out.println(uniqueOccurrences(arr));
    }

    /**
     * 输入：arr = [1,2,2,1,1,3]
     * 输出：true
     * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
     * @param arr
     * @return
     */

    public static boolean uniqueOccurrences(int[] arr) {

        //key 数据  value 次数
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0 ; i < arr.length ; i++) {
            //这块使用JDK8 的Map 接口中的getOrDefault()  就好
//            map.put(arr[i],map.getOrDefault(arr[i],1)+1);
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], ++value);
                continue;
            }
            map.put(arr[i], 1);
        }

        Set<Integer> set = new HashSet<>(map.values());

        if(set.size() != map.size()){
            return false;
        }
        return true;
    }





}
