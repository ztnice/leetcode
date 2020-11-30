package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/26
 */
public class AddStrings {

    public static void main(String[] args) {

        System.out.println(addStrings("132819739217481234","789123671223213456"));
        long a = 132819739217481234L;
        long b = 789123671223213456L;

        System.out.println(a+b);
    }



    // 两个字符串相加
    public static String addStrings(String num1, String num2){

        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() -1 ,j = num2.length() -1; i >= 0 || j >= 0 ;i--,j--){
            carry +=  (i >= 0 ?  num1.charAt(i) - '0' :  0);
            carry +=  (j >= 0 ? num2.charAt(j) - '0': 0);
            stringBuilder.append(carry % 10);
            carry /= 10;
        }
        stringBuilder.append(carry == 1 ? "1" : "");
        return stringBuilder.reverse().toString();
    }


}
