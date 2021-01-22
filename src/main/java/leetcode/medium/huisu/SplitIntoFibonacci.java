package leetcode.medium.huisu;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozt
 * @since 2020/12/8
 */
public class SplitIntoFibonacci {

    public static void main(String[] args) {
        List<Integer> list = splitIntoFibonacci1("123456579");
        System.out.println(list);


    }


    /**
     * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。
     *
     * 形式上，斐波那契式序列是一个非负整数列表 F，且满足：
     *
     * 0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
     * F.length >= 3；
     * 对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
     * 另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。
     *
     * 返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。
     *输入："123456579"
     * 输出：[123,456,579]
     * @param S
     * @return
     */
    public static List<Integer> splitIntoFibonacci(String S) {


        List<Integer>  list = new ArrayList<>();

        backtrack(list,S,S.length(),0,0,0);

        return list;
    }


    public static boolean backtrack(List<Integer> list , String S, int length, int index, int sum, int prev){

        if(index == length){
            return list.size() >= 3;
        }

        long currLong = 0L;
        for(int i = index ; i < length; i++){

            if(i > index && S.charAt(index) =='0' ){
                break;
            }

            currLong = (currLong * 10) + S.charAt(i) - '0';
            if(currLong > Integer.MAX_VALUE){
                break;
            }

            int crr = (int) currLong;
            if(list.size() >= 2){
                if(crr < sum){
                    continue;
                }else if(crr > sum){
                    break;
                }
            }
            list.add(sum);

            if(backtrack(list,S,length,i+1,prev+crr,crr)){
                return true;
            }else {
                list.remove(list.size() -1 );
            }
        }
        return false;
    }



    public static List<Integer> splitIntoFibonacci1(String S) {
        List<Integer> list = new ArrayList<Integer>();
        backtrack1(list, S, S.length(), 0, 0, 0);
        return list;
    }

    public static boolean backtrack1(List<Integer> list, String S, int length, int index, int sum, int prev) {
        if (index == length) {
            return list.size() >= 3;
        }
        long currLong = 0;
        for (int i = index; i < length; i++) {
            if (i > index && S.charAt(index) == '0') {
                break;
            }
            currLong = currLong * 10 + S.charAt(i) - '0';
            if (currLong > Integer.MAX_VALUE) {
                break;
            }
            int curr = (int) currLong;
            if (list.size() >= 2) {
                if (curr < sum) {
                    continue;
                } else if (curr > sum) {
                    break;
                }
            }
            list.add(curr);
            if (backtrack1(list, S, length, i + 1, prev + curr, curr)) {
                return true;
            } else {
                list.remove(list.size() - 1);
            }
        }
        return false;
    }

}
