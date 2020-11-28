package leetcode.simple;

public class StrStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi","issip"));

        System.out.println(strStr1("mississippi","issip"));
    }


    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，
     * 在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {

        if(haystack == null){
            return -1;
        }

        if(needle == null){
            return 0;
        }

        if(needle.equals(haystack)){
            return 0;
        }

        if(haystack.length() == 0){
            return -1;
        }
        if(needle.length() == 0){
            return 0;
        }


        if(!haystack.contains(needle)){
            return -1;
        }

        char v1 = needle.charAt(0);
        int n = 0;
        for(int i = 0; i < haystack.length() ; i++){
            if(haystack.charAt(i) == v1){
                n = i;
                int j = 1;
                if(j == needle.length()){
                    break;
                }
                while (j < needle.length()){
                    i++;
                    if(haystack.charAt(i) != needle.charAt(j)){
                        break;
                    }
                    j++;
                }
                if(j == needle.length()){
                    break;
                }else {
                    i = n;
                }

            }

        }

        return n;

    }



    public static int strStr1(String haystack, String needle) {

        if(haystack == null){
            return -1;
        }

        if(needle == null){
            return 0;
        }

        int n1 = haystack.length(),n2  = needle.length();

        for(int i = 0 ; i < n1 - n2 + 1 ; i++){

            if(haystack.substring(i,i+n2).equals(needle)){
                return i;
            }
        }

        return -1;

    }


}
