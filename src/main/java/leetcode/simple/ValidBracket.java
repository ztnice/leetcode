package leetcode.simple;

import java.util.*;

/**
 * @author haozt
 * @since 2020/11/23
 */
public class ValidBracket {


    public static void main(String[] args) {
        System.out.println(isValid1("([]{}){}"));
    }

    /**
     *给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
     *
     * 有效字符串需满足：
     *
     *     左括号必须用相同类型的右括号闭合。
     *     左括号必须以正确的顺序闭合。
     *
     * 注意空字符串可被认为是有效字符串。
     * @param str
     * @return
     */
   public static boolean isValid(String str){
      // 注意空字符串可被认为是有效字符串。 这句话是什么几把意思？
       if(str == null){
           return false;
       }
       int len = str.length();
       if(len == 0){
           return true;
       }
       if((len & 1) == 1){
           return false;
       }

       //使用哈希表存储元素
       Map<Character, Character> map = new HashMap<Character, Character>() {{
           put(')', '(');
           put(']', '[');
           put('}', '{');
       }};
       //使用数据结构 栈
       Deque<Character> stack = new LinkedList<>();
       for(int i = 0 ; i < len; i++){
           char v  = str.charAt(i);
           if(map.containsKey(v)){
               if(stack.isEmpty() || stack.pop() != map.get(v)){
                   return false;
               }
               continue;
           }
           stack.push(v);
       }
       return stack.isEmpty();
    }


    public static boolean isValid1(String s) {
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
        }

        return s.length() == 0;
    }
}
