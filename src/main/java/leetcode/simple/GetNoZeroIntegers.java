package leetcode.simple;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/10/13
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 *
 *     A 和 B 都是无零整数
 *     A + B = n
 */
public class GetNoZeroIntegers {


    public static void main(String[] args) {

        int[] ints = getNoZeroIntegers(1010);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] getNoZeroIntegers(int n) {

        for(int i = n - 1 ; i > 0 ; i--){

            int res = n - i ;

            if(!containsZero(i) && !containsZero(res)){
                return new int[]{res,i};
            }
        }

        System.out.println("不包含指定元素");
        return new int[]{};

    }




    //判断一个十进制数 是否包含0

    static boolean containsZero(int n){

        String s = String.valueOf(n);

        char[] chars = s.toCharArray();

        for(int i = 0 ;i < chars.length ; i++){
            if(chars[i] == '0'){
                return true;
            }
        }
        return false;
    }


    public boolean isNoZero(int num){
        while(num > 0){
            if(num % 10 == 0){
                return false;
            }
            num /= 10;
        }
        return true;
    }


    /**
     * 依次从个位往高位判断来生成其中的一个子数：
     * 1. 若此位为1，则子数该位取2就一定能保证两个子数该位不为0；否则取1即可；
     * 2. 依次往高位遍历。若遇到最后一位（即x小于10），直接中断即可。
     */
    public static int[] getNoZeroIntegers1(int n) {
            int a = n < 10 ? 1 : 0;
            int digit = 1;
            int x = n;
            while (x > 0) {
                if (x < 10) {
                    break;
                }
                int delta = x % 10 != 1 ? 1 : 2;
                a += delta * digit;
                x -= delta;
                x /= 10;
                digit *= 10;
            }
            return new int[]{a, n - a};
        }


}
