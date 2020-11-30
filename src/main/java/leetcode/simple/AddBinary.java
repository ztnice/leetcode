package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/26
 */
public class AddBinary {

    public static void main(String[] args) {

        String s = addBinary1("11001","110111000111000000111000110");
        String s1 = addBinary("11001","110111000111000000111000110");
        String s2 = addBinary2("11001","110111000111000000111000110");
        // 1100

        System.out.println(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s.equals(s1));

    }


    //二进制求和
    public static String addBinary(String s1,String s2){

        int n  = Math.max(s1.length(),s2.length());

        int carry = 0;
        StringBuilder stringBuilder =  new StringBuilder();
        for(int i = 0 ; i < n ; i++){

            carry += i < s1.length() ? (s1.charAt(s1.length() -1 -i )  - '0') : 0;
            carry += i < s2.length() ? (s2.charAt(s2.length()- 1- i) - '0') : 0;

            stringBuilder.append(carry % 2 );
            carry /= 2;
        }
        if(carry > 0){
            stringBuilder.append("1");
        }
        stringBuilder.reverse();

        return stringBuilder.toString();

    }



    public static String addBinary1(String a,String b){

        int len = Math.max(a.length(),b.length());
        int diff = Math.abs(a.length() - b.length());
        StringBuilder append = new StringBuilder();
        while (diff > 0 ){
            append.append("0");
            diff -- ;
        }

        if(a.length() > b.length()){
            b = append + b ;
        }
        if(a.length() < b.length()){
            a = append + a;
        }

        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = len - 1 ; i >= 0 ; i--){

            carry +=  (a.charAt(i) - '0') ;
            carry +=  (b.charAt(i) - '0') ;

            stringBuilder.append(carry % 2 );
            carry /= 2;
        }

        if(carry > 0){
            stringBuilder.append("1");
        }
        return stringBuilder.reverse().toString();

    }


    public static String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int ca = 0;
        for(int i = a.length() - 1, j = b.length() - 1;i >= 0 || j >= 0; i--, j--) {
            int sum = ca;
            sum += i >= 0 ? a.charAt(i) - '0' : 0;
            sum += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append(sum % 2);
            ca = sum / 2;
        }
        ans.append(ca == 1 ? ca : "");
        return ans.reverse().toString();
    }


}
