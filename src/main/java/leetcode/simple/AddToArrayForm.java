package leetcode.simple;

import java.util.*;

/**
 * @author haozt
 * @since 2020/11/27
 */
public class AddToArrayForm {

    public static void main(String[] args) {
        int[] a = {9,9,9,9,9};
        List<Integer> list = addToArrayForm(a,99);
        List<Integer> list1 = addToArrayForm1(a,99);
        System.out.println(list);
        System.out.println(list1);
    }

    /**
     * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
     *
     * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
     * @param A
     * @param K
     * @return
     */

    public static List<Integer> addToArrayForm(int[] A, int K) {
        // 1 2 3 4   12
        Deque<Integer> stack  = new LinkedList<>();
        int carry = 0;
        int i = A.length - 1;

        if(K != 0 || i >= 0 ){
            while (K != 0 && i >= 0 ){
                int n = K % 10;
                int m = n + A[i] + carry;
                stack.push(m % 10);
                K /= 10;
                carry = m/10;
                i -- ;
            }

            while (i >= 0 ){
                carry = carry + A[i];
                stack.push(carry % 10);
                carry /= 10;
                i--;
            }

            while ( K != 0 ){
                int n = K % 10;
                int m = n + carry;
                stack.push(m % 10);
                K /= 10;
                carry = m/10;
            }

            if(carry > 0){
                stack.push(carry);
            }
        }
        return new ArrayList<>(stack);
    }


    public static List<Integer> addToArrayForm1(int[] A, int K) {
        // 1 2 3 4   12
        Deque<Integer> stack  = new LinkedList<>();
        int carry = 0;
        int i = A.length - 1;

        while ( K != 0 || i >= 0 ){
            int n = K % 10;
            int m = n  + carry;
            if(i >= 0 ){
                m += A[i];
                i--;
            }
            stack.push(m % 10);
            K /= 10;
            carry = m/10;
        }

        if(carry > 0){
            stack.push(carry);
        }
        return new ArrayList<>(stack);
    }
}
