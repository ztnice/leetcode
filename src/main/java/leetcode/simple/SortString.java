package leetcode.simple;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author haozt
 * @since 2020/11/25
 */
public class SortString {

    public static void main(String[] args) {
        String s = "bnxxxxxasdasfddswqewqrtyhllmnvvvbhhuuq";
        //abccbaabccba
        //abccbaabccba
        System.out.println(s.length());
        String s1 = sortString1(s);
        String s2 = sortString(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));

    }


    /**
     * 给你一个字符串 s ，请你根据下面的算法重新构造字符串：
     *
     *     从 s 中选出 最小 的字符，将它 接在 结果字符串的后面。
     *     从 s 剩余字符中选出 最小 的字符，且该字符比上一个添加的字符大，将它 接在 结果字符串后面。
     *     重复步骤 2 ，直到你没法从 s 中选择字符。
     *     从 s 中选出 最大 的字符，将它 接在 结果字符串的后面。
     *     从 s 剩余字符中选出 最大 的字符，且该字符比上一个添加的字符小，将它 接在 结果字符串后面。
     *     重复步骤 5 ，直到你没法从 s 中选择字符。
     *     重复步骤 1 到 6 ，直到 s 中所有字符都已经被选过。
     *
     * 在任何一步中，如果最小或者最大字符不止一个 ，你可以选择其中任意一个，并将其添加到结果字符串。
     *
     * 请你返回将 s 中字符重新排序后的 结果字符串 。
     *  字符串不为空
     */


    //"pqewimemkvmrwxrdtyceeeecytdrxwrmvkmemiweqp"
    //"cdeikmpqrtvwxyyxwvtrqpmkiedcemrwwrmemmeeee"
    //"cdeikmpqrtvwxyyxwvtrqpmkiedcemrwwrmeemmeee"
    public static String sortString(String s) {

        long a = System.currentTimeMillis();
        //先排序
        char[] chars = s.toCharArray();
        Arrays.sort(chars);

        StringBuilder stringBuilder = new StringBuilder();
        Set<Integer> set = new HashSet<>();

        int left = 0,right = chars.length -1;
        int left1 = left, right1 = right;
        char v = '0';
        while (set.size() != chars.length){
            while ( left <= right){
                if(set.size() == chars.length){
                    break;
                }
                if(set.contains(left)){
                    left ++;
                    continue;
                }
                if(v == chars[left] && left != left1){
                    left ++;
                    continue;
                }
                stringBuilder.append(chars[left]);
                set.add(left);
                v = chars[left];
                left ++;
            }
            left = ++left1;

            v = chars[right];
            while (right >= left){
                if(set.size() == chars.length){
                    break;
                }
                if(set.contains(right)){
                    right --;
                    continue;
                }
                if(v == chars[right] && right != right1){
                    right --;
                    continue;
                }

                stringBuilder.append(chars[right]);
                set.add(right);
                v = chars[right];
                right --;
            }
            right = -- right1;
            v = chars[left];
        }

        long b  = System.currentTimeMillis();
        System.out.println( (b-a) +":ms" );
        return stringBuilder.toString();
    }


    public static String sortString1(String s) {

        long a = System.currentTimeMillis();
        int[] nums = new int[26];
        for(int i = 0 ; i < s.length(); i++){
            nums[s.charAt(i) - 'a'] ++;
        }

        StringBuilder stringBuilder = new StringBuilder();

        while (stringBuilder.length() < s.length()){

            for(int i = 0 ; i < 26 ; i++){
                if(nums[i] > 0){
                    stringBuilder.append((char) (i + 'a'));
                    nums[i] -- ;
                }
            }

            for(int i = 25; i >= 0 ; i--){
                if (nums[i] > 0) {
                    stringBuilder.append((char) (i + 'a'));
                    nums[i]--;
                }
            }
        }
        long b  = System.currentTimeMillis();
        System.out.println( (b-a) +":ms" );
        return stringBuilder.toString();

    }

}
