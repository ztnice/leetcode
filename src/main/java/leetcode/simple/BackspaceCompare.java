package leetcode.simple;

/**
 * @author haozt
 * @since 2020/10/19
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 */
public class BackspaceCompare {


    public static void main(String[] args) {
        //"hd#dp#czsp#####"
        //"hd#dp#cs#zspj######"
        //"j##xfix"
        //"j###xfix"
       boolean b =  backspaceCompare("j##xfix","j###xfix");
        System.out.println(b);
    }


    public static boolean backspaceCompare(String S, String T) {
        //假设 S 和 T 都不是 空

        S = build1(S);
        T = build1(T);

        return S.equals(T);

    }




    //感觉自己跟个傻逼一样 写了这么多代码 卧槽
    public  static String getNotContainsBackSpaceStr(String str){

        StringBuilder stringBuilder = new StringBuilder();

        char[] chars = str.toCharArray();
        if(chars[0] == '#'){
            chars [0] = '\0';
        }

        int count = 0;
        for(int i= 1 ; i < chars.length ; i++){
            count = i - 1;
            while (i < chars.length && chars[i] == '#' ){

                if(chars[count] != '#' && chars[count] != '\0'){
                    chars [count] = '\0';
                    if(count > 0 ){
                        count--;
                    }
                }else {
                    while (chars[count] == '#' || chars [count] == '\0' ){
                        if(--count < 0){
                            count = 0;
                            break;
                        }
                        if(chars[count] != '#' && chars [count] != '\0'){
                            chars [count] = '\0';
                            break;
                        }
                    }
                }

                i++;

            }
        }

        for(int i= 0 ; i < chars.length ; i++){
            stringBuilder.append(chars[i]);
        }

        String result = stringBuilder.toString();
        result = result.replaceAll("#","").replaceAll("\0","");
        return result;
    }


    //精简版
    public static String build(String str){

        int length = str.length();

        StringBuilder stringBuilder = new StringBuilder();

        for(int i = 0 ; i < length ; i++){
            char value = str.charAt(i);
            if(value != '#'){
                stringBuilder.append(value);
            }else {
                if(stringBuilder.length() > 0){
                    stringBuilder.deleteCharAt(stringBuilder.length() -1 );
                }
            }
        }
        return stringBuilder.toString();

    }



    public static String build1(String str){
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder();
        int  count = 0;
        for(int i = length -1 ; i >= 0 ; i--){
            char value = str.charAt(i);
            if(value == '#'){
                count ++;
                continue;
            }
            if(count > 0){
                count --;
                continue;
            }
            stringBuilder.append(value);
        }
        return stringBuilder.toString();

    }

    //双指针法
    public static boolean backspaceCompare1(String S, String T) {

        int i = S.length() -1 , j = T.length() -1;

        int skipS = 0 , skipT = 0;

        while (i >= 0 || j >= 0){

            while ( i >= 0 ){
                if(S.charAt(i) == '#'){
                    i--;
                    skipS++;
                }else if(skipS > 0) {
                    i--;
                    skipS--;
                }else {
                    break;
                }

            }


            while ( j >= 0 ){
                if(T.charAt(j) == '#'){
                    j--;
                    skipT++;
                }else if(skipT > 0) {
                    j--;
                    skipT--;
                }else {
                    break;
                }

            }

            if(i >= 0 && j >= 0){
                if(S.charAt(i) != T.charAt(j)){
                    return false;
                }
            }else if( i >= 0 || j >= 0) {
                return false;
            }

            i--;
            j--;
        }

        return true;
    }




}
