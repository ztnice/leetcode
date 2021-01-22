package leetcode.simple;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author haozt
 * @since 2020/12/16
 */
public class WordPattern {

    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }


    /**
     * 给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。
     *
     * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
     *你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
     */


    public static boolean wordPattern(String pattern, String s) {

        Map<Character,String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strings = s.split("\\s+");

        int len = pattern.length();
        if(strings.length != len){
            return false;
        }

        for(int i = 0 ; i < pattern.length() ; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                String value = map.get(c);
                if(!value.equals(strings[i])){
                    return false;
                }
            }else{
                if (set.contains(strings[i])){
                    return false;
                }
            }
            map.put(c,strings[i]);
            set.add(strings[i]);
        }
        return true;
    }

}
