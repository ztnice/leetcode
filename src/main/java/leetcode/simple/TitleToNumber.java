package leetcode.simple;

/**
 * @author haozt
 * @since 2021/1/22 0022
 */
public class TitleToNumber {

    public static void main(String[] args) {


        System.out.println(titleToNumber("AAA"));
        System.out.println(titleToNumber1("AAA"));


    }


    public static int titleToNumber(String s) {

        // A 1  A-64   B  B-64 2      Z Z-64  26

        //AA 27  26*(A-64)+(A-64)

        //AAA   26*26*(A-64) +26*(A-64)+(A-64)

        int res = 0;
        int count = 0;
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            char v = s.charAt(i);

            if(count == 0){
                res += (v - 64);
            }else {
                int count1 = count;
                int res1 = 1;
                while (count1 > 0){
                    res1 *= 26;
                    count1--;
                }
                res1 *= (v - 64);
                res += res1;
            }
            count++;
        }
        return res;
    }


    public static int titleToNumber1(String s) {

        // A 1  A-64   B  B-64 2      Z Z-64  26

        //AA 27  26*(A-64)+(A-64)

        //AAA   26*26*(A-64) +26*(A-64)+(A-64) = 26*(A-64)*(26+1) + (A -64)

        //这里后面一步用到前面一步的计算结果

        int ans = 0;
        for(int i = 0 ; i < s.length() ; i++){
            int num = s.charAt(i) - 'A' + 1;
            ans = 26 * ans + num;
        }
        return ans;

    }
}
