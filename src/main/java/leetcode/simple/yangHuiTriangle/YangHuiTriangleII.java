package leetcode.simple.yangHuiTriangle;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozt
 * @since 2020/12/1
 */
public class YangHuiTriangleII {

    public static void main(String[] args) {

        List<Integer>  list = getRow(4);
        System.out.println(list);

        List<Integer>  list1 = getRow1(4);
        System.out.println(list1);
    }


    /**
     * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
     * 在杨辉三角中，每个数是它左上方和右上方的数的和。
     */

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> preList = new ArrayList<>();
        preList.add(1);
        for(int i  = 1 ; i <= rowIndex; i++){
            List<Integer> list = new ArrayList<>();
            list.add(1);
            int size = preList.size();
            for(int j = 1 ; j < size;j++){
                int n1 = preList.get(j -1);
                int n2 = preList.get(j);
                list.add(n1 + n2);
            }
            list.add(1);
            preList = list;
        }
        return preList;
    }


    public static List<Integer> getRow1(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i <= rowIndex ; i++){
            list.add(1);
            for(int j = i -1 ; j > 0 ; j--){
                list.set(j,list.get(j) + list.get(j -1));
            }
        }
        return list;
    }
}
