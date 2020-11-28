package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {


    public static void main(String[] args) {
        List<String> ll = generateParenthesis1(3);
        System.out.println(ll);
    }


    //括号排列组合  有效的括号

    public static List<String> generateParenthesis(int n) {

        List<String> list = new ArrayList<>();

        generateAll(new char[2*n],0,list);


        return list;
    }



    public static void  generateAll(char[] chars,int index,List<String> dataList){

        if(chars.length == index){
            if(valid(chars)){
                dataList.add(new String(chars));
            }
        }else {

            chars[index] = '(';
            generateAll(chars,index + 1,dataList);
            chars[index] = ')';
            generateAll(chars,index + 1,dataList);
        }

    }



    public static List<String> generateParenthesis1(int n) {

        List<String> ans = new ArrayList<String>();
        backtrack(ans, new StringBuilder(), 0, 0, n);
        return ans;
    }

    public static void backtrack(List<String> ans, StringBuilder cur, int open, int close, int max) {
        if (cur.length() == max * 2) {
            ans.add(cur.toString());
            return;
        }

        /**
         * 当n = 1 时，open = 0 和 1 max = 1 close = 0 和 1
         * 组合（0,0）->进入 （1,0）   （0,1）->进入  （1,1）
         *
         */

        if (open < max) {
            cur.append('(');
            backtrack(ans, cur, open + 1, close, max);
            cur.deleteCharAt(cur.length() - 1);
        }
        if (close < open) {
            cur.append(')');
            backtrack(ans, cur, open, close + 1, max);
            cur.deleteCharAt(cur.length() - 1);
        }
    }



    public static boolean valid(char[] chars){

        int n = 0;

        for(int i =  0 ; i < chars.length ; i++){

            if('(' == chars[i]){
                n++;
                continue;
            }
            n--;

            if(n < 0){
                return false;
            }
        }

        return n == 0;

    }

}
