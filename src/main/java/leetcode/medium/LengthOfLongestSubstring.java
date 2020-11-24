package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author haozt
 * @since 2020/10/29
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
 */
public class LengthOfLongestSubstring {


    public static void main(String[] args) {
        int i = lengthOfLongestSubstring1("ccc");
        String sre = longestPalindrome1("ababababaa");
        String sre1 = longestPalindrome("ababababaa");
        System.out.println(i);
        System.out.println(sre);
        System.out.println(sre1);
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }
        int right = 0;
        Set<Character> set = new HashSet<>();
        int max = 1;
        int n = s.length();
        //abcdeafg
        for (int i = 0; i < n; i++) {
            if(i != 0){
                set.remove(s.charAt(i-1));
            }
            while (right  < n && !set.contains(s.charAt(right ))){
                set.add(s.charAt(right ));
                right++;
            }
            max = max > (right - i)  ? max : (right - i) ;
        }
        return max;

    }



    public static int lengthOfLongestSubstring1(String s) {

        if(s.length() == 0){
            return 0;
        }

        int left = 0 ;
        int max = 1;

        //abcdefga er
        Map<Character,Integer> map = new HashMap<>();

        for(int i = 0 ; i < s.length() ; i++){

            if(map.containsKey(s.charAt(i))){
                int val = map.get(s.charAt(i)) + 1;
                left = val > left ? val : left ;
            }
            map.put(s.charAt(i),i);
            max = max > (i - left) + 1 ? max : (i - left) + 1;
        }

        return max;
    }


    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * @param s
     * @return
     * 备注 貌似题意理解错了
     */
    public  static  String longestPalindrome(String s) {

        if(s.length() == 0){
            return "";
        }
        //abcbeafasdsadsade   eafasdsadsade
        int left = 0 ;
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        String result = s.substring(0,1);
        for(int i = 0 ; i < s.length() ; i++){
            if(map.containsKey(s.charAt(i))){
                left = map.get(s.charAt(i));
                if(max < (i - left) + 1){
                    result = s.substring(left,i + 1);
                }
                max = Math.max(max, (i - left) + 1 );
                continue;
            }
            map.put(s.charAt(i),i);
        }
        return result;

    }


    public static String longestPalindrome1(String s){
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int l = 0; l < n; ++l) {
            for (int i = 0; i + l < n; ++i) {
                int j = i + l;
                if (l == 0) {
                    dp[i][j] = true;
                } else if (l == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && l + 1 > ans.length()) {
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }



    /**
     * 给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
     *
     * 网格中的格子水平和垂直方向相连（对角线方向不相连）。整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
     *
     * 岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。
     * @param grid
     * @return
     */
    public int islandPerimeter(int[][] grid) {

        int length = 0;
        for(int i = 0 ; i < grid.length; i++){
            int []  arr = grid[i];
            for( int j = 0 ; j < arr.length ; j++){
                int val = grid[i][j];
                if(val == 1){
                    //上边界
                    if(i == 0 || grid[i-1][j] == 0){
                        length++;
                    }
                    //下边界
                    if(i == grid.length - 1 || grid[i+1][j] == 0){
                        length ++;
                    }
                    //左边界
                    if(j == 0 || grid[i][j-1] == 0){
                        length ++;
                    }
                    //右边界
                    if(j == grid[0].length - 1 || grid[i][j+1] == 0){
                        length ++;
                    }

                }

            }
        }

        return  length;

    }




    public int islandPerimeter1(int[][] grid) {

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ;j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    return dfs(grid,i,j);
                }
            }
        }
        return  0 ;
    }


    int dfs(int[][] grid, int r , int c){

        // 从一个岛屿方格走向网格边界，周长加 1
        if( ! (0 <= r && r < grid.length && 0 <= c && c < grid[0].length )){
            return 1;
        }
        if(grid[r][c] != 1){
            return 1;
        }

        grid[r][c] =  -1 ;//为防止递归出现死循环 已经统计过的周边值进行修改

        return  dfs(grid,r-1,c) +//上边相邻
        dfs(grid,r+1,c) +//下边相邻
        dfs(grid,r,c-1) +//左边相邻
        dfs(grid,r,c+1) ;//右边相邻
    }


}
