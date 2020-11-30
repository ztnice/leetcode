package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/27
 */
public class ReverseLeftWords {

    public static void main(String[] args) {

        StringBuilder stringBuilder  = new StringBuilder();
        for(int i = 0 ; i < 1000; i++){
            stringBuilder.append(i);
        }

        String str = stringBuilder.toString();
        System.out.println(reverseLeftWords(str,100));
        System.out.println(reverseLeftWords1(str,100));
        System.out.println(reverseLeftWords2(str,100));
    }

    /**
     * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
     *
     * @param s
     * @param n
     * @return
     */
    public static String reverseLeftWords(String s, int n) {
        Long st = System.currentTimeMillis();

        String s1 = s.substring(0, n);
        String s2 = s.substring(n);
        s = s2 + s1;

        Long end = System.currentTimeMillis();
        System.out.println((end - st)+":ms");
        return s;


    }


    public static String reverseLeftWords1(String s, int n) {
        Long st = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n ; i < s.length() ; i++){
            stringBuilder.append(s.charAt(i));
        }

        for (int i = 0 ; i < n ; i++){
            stringBuilder.append(s.charAt(i));
        }

        Long end = System.currentTimeMillis();
        System.out.println((end - st)+":ms");
        return stringBuilder.toString();
    }



    public static String reverseLeftWords2(String s, int n) {
        //想到环形链表了 跟题目没有任何关系
        //a -> b -> c->d->e->f->a  7
        //0. a,a  1.b,c  2.c,f  3.d,b 4.e,e  5.f,a  6.a,c 7.b,e 8.c,a 9.d,c 10.e,e

        Long st = System.currentTimeMillis();
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = n ; i < s.length() + n  ; i++){
            stringBuilder.append(s.charAt(i % s.length()));
        }
        Long end = System.currentTimeMillis();
        System.out.println((end - st)+":ms");
        return stringBuilder.toString();
    }


}
