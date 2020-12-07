package leetcode.simple;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/12/3
 */
public class CountPrimes {

    public static void main(String[] args) {
        System.out.println(countPrimes1(100));
    }


    /**
     * 统计所有小于非负整数 n 的质数的数量。
     * @param n
     * @return
     */
    public static int countPrimes1(int n) {
        int[] arr = new int[n];
        Arrays.fill(arr,1);
        int sum = 0;
        for(int i = 2 ; i < n ; i++){
            if(arr[i] == 1){
                sum++;
                if( (long)i * i < n){
                    for(int j = i * i ; j < n; j+= i){
                        arr[j] = 0;
                    }
                }

            }
        }
        return sum;
    }



    //翻车 数据大的时候 就超时了
    public static int countPrimes(int n) {
        int sum = 0;
        for(int i = 2; i < n ; i++){
            sum += isPrimes(i) ? 1 : 0;
        }
        return sum;
    }

    public static boolean isPrimes(int n){

        if(n <= 1){
            return false;
        }

        for (int i = 2; i * i <= n; ++i) {
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

}
