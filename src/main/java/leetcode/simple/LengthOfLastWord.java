package leetcode.simple;

public class LengthOfLastWord {

    public static void main(String[] args) {

        String s  = "Helloworld   ";
        int i = lengthOfLastWord(s);
        int i1 = lengthOfLastWord1(s);
        int i2 = lengthOfLastWord2(s);
        System.out.println(i);
        System.out.println(i1);
        System.out.println(i2);
    }


    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。

     如果不存在最后一个单词，请返回 0 。

     说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
     * @param s
     * @return
     */
    public static int lengthOfLastWord(String s) {

        int count = 0;
        int right = s.length() - 1;
        while (right >= 0 ){
            char c = s.charAt(right);
            if(c == ' '){
                if(count > 0){
                    return count;
                }
                while (s.charAt(right) == ' '){
                    right--;
                    if(right < 0){
                        return count;
                    }
                }
            }

            right--;
            count ++;
        }

        return count;
    }




    //推荐这种写法 可读性高
    public static int lengthOfLastWord1(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' '){
            end--;
        }
        if(end < 0) return 0;
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ' ){
            start --;
        }
        return end - start;
    }

    public static int lengthOfLastWord2(String s) {

        int count = 0;
        for(int i = s.length() -1 ; i >=0 ; i--){

            if(s.charAt(i) == ' '){
                if(count == 0){
                    continue;
                }
                break;
            }

            count ++;
        }

        return count;
    }
}
