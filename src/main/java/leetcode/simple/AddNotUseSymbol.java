package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/27
 * 不使用加号的数字和其他算术运算符的数字求和
 */
public class AddNotUseSymbol {

    public static void main(String[] args) {

        int res = add(-1,2);
        System.out.println(res);
    }

    public static int add (int a ,int b){
        //5 + 7 = 12 => 0101 + 0111  = 1100  0010  0101  01010
        //转换为二进制后
        //不考虑进位 a + b 跟 a^b 是一样的
        //考虑进位 a + b  = a ^ b + ((a & b) << 1)
        while (b != 0){
            int sum = a ^ b ;
            int carry = ( a & b ) << 1;
            a = sum;
            b = carry;
        }
        return a;

    }
}
