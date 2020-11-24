package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozt
 * @since 2020/11/17
 */
public class ZString {

    public static void main(String[] args) {

        System.out.println(convert("LEETCODEISHIRING",3));

    }


    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     *
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     *
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     *
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     *
     * 请你实现这个将字符串进行指定行数变换的函数：
     */
    public static String convert(String s, int numRows) {

        if(numRows <= 1){
            return s;
        }

        List<StringBuilder> stringBuilders  = new ArrayList<>();

        for( int i = 0 ; i < Math.min(numRows,s.length()) ; i++){

            stringBuilders.add(new StringBuilder());

        }

        int currentRow = 0 ,flag = -1;

        for(int i = 0 ; i < s.length(); i++){
            stringBuilders.get(currentRow).append(s.charAt(i));

            if(currentRow == 0 ||  currentRow == numRows - 1){
                flag = - flag;
            }
            currentRow += flag;
        }

        StringBuilder stringBuilder = new StringBuilder();

        for(StringBuilder builder : stringBuilders){
            stringBuilder.append(builder) ;
        }


        return stringBuilder.toString();

    }

}
