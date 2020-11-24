package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/19
 */
public class LongestCommonPrefix {


    public static void main(String[] args) {
        String[] s = {"aa","aaa"};
        System.out.println(longestCommonPrefix2(s));
    }


    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     *
     * 如果不存在公共前缀，返回空字符串 ""。
     * @param strs
     * @return
     */
    public  static String longestCommonPrefix(String[] strs) {

        String res = "";
        if(strs.length == 0){
            return res;
        }
        if(strs.length == 1){
            return strs[0];
        }
        StringBuilder stringBuilder = new StringBuilder();

        String str = strs[0];

        for(int i = 0 ; i < str.length(); i++){
            res = stringBuilder.toString();
            stringBuilder.append(str.charAt(i));
            for(int j = 1 ; j < strs.length ; j++){
                if(strs[j] == null || strs[j].equals("")){
                    return res;
                }
                if(!strs[j].startsWith(stringBuilder.toString())){
                    return res;
                }
            }
            res = stringBuilder.toString();
        }
        return res;
    }


    public  static String longestCommonPrefix1(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1 ; i < strs.length ;i ++ ){
            str = longestCommonPrefix(str, strs[i]);
            if(str.length() == 0){
                break;
            }
        }
        return str;
    }

    public  static String longestCommonPrefix(String str1, String str2) {

        int len = Math.min(str1.length(),str2.length());
        int index = 0;
        while (index < len && str1.charAt(index) == str2.charAt(index)){
            index++;
        }

        return str1.substring(0,index);

    }





    public  static String longestCommonPrefix2(String[] strs) {

        if(strs == null || strs.length == 0){
            return "";
        }
        String str = strs[0];

        for(int i = 0 ; i < str.length(); i++){
            char v = str.charAt(i);
            for(int j = 1; j < strs.length; j++){
                if(i == strs[j].length() || v != strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return str;
    }
}
