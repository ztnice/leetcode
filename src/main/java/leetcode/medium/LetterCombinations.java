package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author haozt
 * @since 2020/11/23
 */
public class LetterCombinations {

    public static void main(String[] args) {
        letterCombinations("23456789");
    }



    public static List<String> letterCombinations(String digits) {

        Map<Character,String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> list = new ArrayList<>();
        if(digits == null || digits.length() == 0){
            return list;
        }


        backTrack(list,map,0,digits,new StringBuilder());

        return list;

    }


    public static void backTrack(List<String> list,Map<Character,String> map,int index,String digits,StringBuilder
                          stringBuilder){
        if(index == digits.length()){
            list.add(stringBuilder.toString());
        }else {
            char digit =  digits.charAt(index);
            String letter = map.get(digit);
            int count = letter.length();
            for(int i = 0 ; i < count ; i++){
                stringBuilder.append(letter.charAt(i));
                backTrack(list,map,index+1,digits,stringBuilder);
                stringBuilder.deleteCharAt(index);
            }
        }
    }




}
