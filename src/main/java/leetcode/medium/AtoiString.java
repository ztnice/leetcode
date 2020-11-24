package leetcode.medium;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * @author haozt
 * @since 2020/11/13
 *  字符串转换整数 (atoi)
 */
public class AtoiString {


    public static void main(String[] args) {



//        System.out.println(myAtoi(""));

        System.out.println(isPalindrome(211111112));
    }


    public static int myAtoi(String s) {

        if(s == null || s.isEmpty()){
            return 0;
        }

        int len = s.length();
        char[] array = s.toCharArray();
        int index  = 0;
        //去除前导空字符
        while (index < len && array[index] == ' '){
            index++;
        }

        // 极端情况 “                 ”
        if(index == len){
            return 0;
        }

        //如果出现符号 仅指第一个符号 只有 +  和 -
        int sign = 1;
        char firstChar = array[index];
        if(firstChar == '-'){
            index ++;
            sign = -1;
        }
        if(firstChar == '+'){
            index ++;
        }

        //将后续出现的数字字符进行转换
        int result = 0;
        while (index < len){

            char current = array[index];
            if(current > '9' || current < '0'){
                break;
            }

            //题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判：断乘以 10 以后是否越界

            if(result > Integer.MAX_VALUE /10 ||
                    (result == Integer.MAX_VALUE / 10 && current - '0' > Integer.MAX_VALUE % 10)){

                return Integer.MAX_VALUE;
            }


            if(result < Integer.MIN_VALUE / 10 ||
                    (result == Integer.MIN_VALUE / 10 &&  (current - '0') > -(Integer.MIN_VALUE % 10 ))){
                return Integer.MIN_VALUE;
            }
            result = result * 10 + sign * (current - '0');
            index ++;
        }
        return result;
    }


    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //521  -> 125
        int res = 0;
        int n = 0;
        int m = x;
        while (m > 0){
            n = m % 10;
            m = m /10;
            res  = res * 10 + n;
        }
        return res == x;

    }






}
