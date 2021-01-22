package leetcode.simple;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author haozt
 * @since 2020/12/12
 */
public class ConvertToTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(7021));
        System.out.println(convertToTitle1(7021));

    }


    /**
     * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {

        String[] str = {"A","B","C","D","E","F","G","H"
        ,"I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X"
        ,"Y","Z"};


        Stack<Integer> stack = new Stack<>();
        while ( n != 0){
            n -- ;
            stack.push(n % 26);
            n /= 26;
        }


        StringBuilder stringBuilder = new StringBuilder();

        while (!stack.isEmpty()){
            int i = stack.pop();
            stringBuilder.append(str[i]);
        }
        return stringBuilder.toString();
    }


    public static String convertToTitle1(int n) {

        StringBuilder stringBuilder = new StringBuilder();

        while (n != 0){
            n -- ;
            stringBuilder.append((char) ('A'+ (n % 26)));
            n /= 26 ;
        }

        return stringBuilder.reverse().toString();

    }

}
