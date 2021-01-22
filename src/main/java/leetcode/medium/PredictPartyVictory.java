package leetcode.medium;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author haozt
 * @since 2020/12/11
 */
public class PredictPartyVictory {

    public static void main(String[] args) {
        System.out.println(predictPartyVictory("RDD"));
    }


    /**
     * 给定一个字符串代表每个参议员的阵营。字母 “R” 和 “D” 分别代表了 Radiant（天辉）和 Dire（夜魇）。然后，如果有 n 个参议员，给定字符串的大小将是 n。
     *
     * 以轮为基础的过程从给定顺序的第一个参议员开始到最后一个参议员结束。这一过程将持续到投票结束。所有失去权利的参议员将在过程中被跳过。
     *
     * 假设每一位参议员都足够聪明，会为自己的政党做出最好的策略，你需要预测哪一方最终会宣布胜利并在 Dota2 游戏中决定改变。输出应该是 Radiant 或 Dire。
     *
     * @param senate
     * @return
     */
    public static String predictPartyVictory(String senate) {
        Queue<Integer> rQueue = new LinkedList<>();
        Queue<Integer> dQueue = new LinkedList<>();

        String[] result = {"Radiant","Dire"};
        int len = senate.length();
        for(int i = 0 ; i < len; i++){
            char v = senate.charAt(i);
            if(v == 'R'){
                rQueue.offer(i);
                continue;
            }
            dQueue.offer(i);
        }




        while (!rQueue.isEmpty() && !dQueue.isEmpty()){

            int rIndex = rQueue.poll();
            int dIndex = dQueue.poll();

            if(rIndex < dIndex){
                rQueue.offer(rIndex + len);
                continue;
            }
            dQueue.offer(dIndex + len);
        }

        return dQueue.isEmpty() ? result[0] : result[1];

    }

}

