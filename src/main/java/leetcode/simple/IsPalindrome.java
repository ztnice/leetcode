package leetcode.simple;

/**
 * @author haozt
 * @since 2020/12/7
 */
public class IsPalindrome {


    public static void main(String[] args) {

        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));

    }


    public  static boolean isPalindrome(String s) {
        if(s  == null || s.length() == 0){
            return true;
        }

        StringBuilder srcBuilder = new StringBuilder();
        StringBuilder tarBuilder = new StringBuilder();

        int left = 0 , n = s.length() -1 ,right = n ;

        while (left <= n || right >= 0){
            if(left <= n){
                char l = s.charAt(left);
                if(append(l)){
                    srcBuilder.append(l);
                }
                left ++;
            }

            if(right >= 0){
                char r = s.charAt(right);

                if(append(r)){
                    tarBuilder.append(r);
                }

                right--;
            }
        }

        return srcBuilder.toString().toUpperCase().equals(tarBuilder.toString().toUpperCase());

    }


    public static boolean append(char v){
        if(v ==' '){
            return false;
        }
        if((v >= 'a' && v <= 'z') || (v >= 'A' && v <= 'Z') || (v >= '0' && v<='9')){
            return true;
        }
        return false;
    }


    public boolean isPalindrome1(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgood_rev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgood_rev.toString());
    }




    public boolean isPalindrome2(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        int n = sgood.length();
        int left = 0, right = n - 1;
        while (left < right) {
            if (Character.toLowerCase(sgood.charAt(left)) != Character.toLowerCase(sgood.charAt(right))) {
                return false;
            }
            ++left;
            --right;
        }
        return true;
    }


    public boolean isPalindrome3(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                ++left;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                --right;
            }
            if (left < right) {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }
                ++left;
                --right;
            }
        }
        return true;
    }


}
