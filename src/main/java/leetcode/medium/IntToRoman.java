package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haozt
 * @since 2020/11/19
 * 整数转罗马数字
 */
public class IntToRoman {


    static int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    static Map<String,Integer> map = new HashMap<>();
    static Map<Character,Integer> map1 = new HashMap<>();
    static Map<Character,Integer> map2 = new HashMap<>();
    static {
        for(int i = 0 ; i < value.length ;i++){
            map.put(symbols[i],value[i]);
        }
        map1.put('M',1000);
        map1.put('D',500);
        map1.put('C',100);
        map1.put('L',50);
        map1.put('X',10);
        map1.put('V',5);
        map1.put('I',1);

        map2.put('M',1000);
        map2.put('D',500);
        map2.put('C',100);
        map2.put('L',50);
        map2.put('X',10);
        map2.put('V',5);
        map2.put('I',1);
        map2.put('a' ,4);
        map2 .put('b',9);
        map2 .put('c',40);
        map2 .put('d',90);
        map2 .put('e', 400);
        map2 .put('f', 900);
    }

    public static void main(String[] args) {
        //CDLXX
        System.out.println(romanToInt2(intToRoman(1456)));
    }


    public  static String intToRoman(int num) {

        StringBuilder stringBuilder =  new StringBuilder();

        for (int i = 0 ; i < value.length && num > 0 ; i++){

            while (value[i] <= num){
                num -= value[i];
                stringBuilder.append(symbols[i]);
            }
        }

        return stringBuilder.toString();
    }



    public static int romanToInt(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int len = s.length();

        if(len == 1){
            return map.get(s);
        }

        int left = 0 , result  = 0;

        while (left < len ){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(s.charAt(left));
            int i = left + 1;
            if(i < s.length()){
                ++left ;
                stringBuilder.append(s.charAt(left));
            }

            if(!map.containsKey(stringBuilder.toString())){
                left--;
                stringBuilder = new StringBuilder();
                stringBuilder.append(s.charAt(left));
            }

            if(!map.containsKey(stringBuilder.toString())){
                break;
            }
            result += map.get(stringBuilder.toString()) ;
            left++;

        }

        return result;



    }

    public static int romanToInt1(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int res = 0;
        int pre = map1.get(s.charAt(0));
        for(int i = 1 ;i < s.length(); i++){
            char v = s.charAt(i);
            int curr = map1.get(v);
            if(curr > pre){
                res -=  pre;
            }else {
                res +=  pre;
            }
            pre = curr;
        }
        res += pre;
        return res;

    }

    /**
     * 秀儿上线
     * @param s
     * @return
     */
    public static int romanToInt2(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        s = s.replace("IV","a");
        s = s.replace("IX","b");
        s = s.replace("XL","c");
        s = s.replace("XC","d");
        s = s.replace("CD","e");
        s = s.replace("CM","f");

        int res = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            res += map2.get(s.charAt(i));
        }
        return res;

    }
}
