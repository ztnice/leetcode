package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/24
 */
public class IsOneBitCharacter {


    public static void main(String[] args) {

        int[] arr = {1,1,1,0};

        System.out.println(isOneBitCharacter(arr));
        System.out.println(isOneBitCharacter2(arr));


    }

    //100  110 10 110

    // 0  10  11  三种情况
    public static boolean isOneBitCharacter(int[] bits) {

        int n = 0;
        int i = 0;
        while (i < bits.length){
            n = bits[i];
            if(bits[i] == 0){
                i++;
                continue;
            }
            i += 2;
        }
        return n == 0;
    }


    public static boolean isOneBitCharacter1(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            i += bits[i] + 1;
        }
        return i == bits.length - 1;
    }

    //贪心算法
    public static boolean isOneBitCharacter2(int[] bits) {
        int i = bits.length - 2;
        while (i >= 0 && bits[i] > 0){
            i -- ;
        }
        return ((bits.length - i) & 1) == 0;
    }


}
