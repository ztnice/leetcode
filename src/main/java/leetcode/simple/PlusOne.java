package leetcode.simple;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] arr = {9};
        arr = plusOne(arr);
        System.out.println(Arrays.toString(arr));
    }


    /**
     *给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

     最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

     你可以假设除了整数 0 之外，这个整数不会以零开头。

     */
    public static int[] plusOne(int[] digits) {

        int carry = 1;
        int n = digits.length - 1;
        for(int i = n; i >=0 ; i--){
            if(carry == 0){
                break;
            }
            int num = digits[i] + carry;
            carry = num / 10;
            num = num % 10;
            digits[i] = num;
        }

        if(carry > 0){
            digits = new int[n + 2];
            digits[0] = carry;
        }
        return  digits;
    }



    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
