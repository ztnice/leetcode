package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/25
 */
public class AddDigits {


    public static void main(String[] args) {
        int a = addDigits(10);
        System.out.println(a);
    }

    /**
     * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
     *
     * 示例:
     *
     * 输入: 38
     * 输出: 2
     * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
     *
     * @return
     */
    public static int addDigits(int num) {
        int res = add(num);
        while (res >= 10){
            res = add(res);
        }
        return res;
    }

    //这个牛逼 不是我想出来的
    public static int addDigits1(int num) {
        return (num - 1) % 9 + 1;
    }


    public static int add(int num){
        int res = 0 ,n  = 0;
        while (num >= 10 ){
            n = num % 10;
            num /= 10;
            res += n;
        }
        res += num;
        return res;
    }



}
