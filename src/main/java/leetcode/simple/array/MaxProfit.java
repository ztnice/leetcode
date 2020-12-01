package leetcode.simple.array;

/**
 * @author haozt
 * @since 2020/12/1
 */
public class MaxProfit {

    public static void main(String[] args) {

        //  2 4 10 8 1
        int[] arr = {2,5,1,3};
        int max = maxProfit1(arr);
        System.out.println(max);
    }


    /**
     * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
     *
     * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
     *
     * 注意：你不能在买入股票前卖出股票。
     *
     * 例如：
     * 输入: [7,1,5,3,6,4]
     * 输出: 5
     * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0 ; i < prices.length ; i++){
            for(int j = i + 1; j < prices.length ; j++){
                int n = prices[j] - prices[i];
                if(n > max){
                    max = n;
                }
            }
        }
        return max;
    }


    public static int maxProfit1(int[] prices) {
        int max = 0,min = Integer.MAX_VALUE;
        for(int i = 0 ; i < prices.length ; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] - min;
            }
        }
        return max;
    }

}
