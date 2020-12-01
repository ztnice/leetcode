package leetcode.simple.yangHuiTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozt
 * @since 2020/12/1
 */
public class YangHuiTriangle {


    public static void main(String[] args) {
        System.out.println(generate(2));
    }


    /**
     * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     * @param numRows
     * @return
     */
    public static List<List<Integer>> generate(int numRows) {

        List<List<Integer>> lists = new ArrayList<>();
        if(numRows == 0){
            return lists;
        }
        List<Integer> lastList = new ArrayList<>();
        lastList.add(1);
        lists.add(lastList);
        for(int i  = 1 ; i < numRows; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int size = lastList.size();
            for(int j = 1 ; j < size;j++){
                int n1 = lastList.get(j -1);
                int n2 = lastList.get(j);
                list.add(n1 + n2);
            }
            list.add(1);
            lists.add(list);
            lastList = list;
        }

        return lists;
    }
}
