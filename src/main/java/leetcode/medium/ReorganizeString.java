package leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author haozt
 * @since 2020/11/30
 */
public class ReorganizeString {

    public static void main(String[] args) {
        String s1 = "aaab";//abaeacaca
        //1,1  2,2  3,2  4,3  5,4  6,4 7,5  8,5  9,6

        //s.len - max  < max

        String s = reorganizeString(s1);
        System.out.println(s);
        System.out.println(s.length() == s1.length());
    }


    public static String reorganizeString(String S) {

        int[] arr = new int[26];
        int maxCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < S.length(); i++){
            int index = S.charAt(i) - 'a';
            arr[index] += 1;
            maxCount = Math.max(arr[index],maxCount);
        }

        int len = S.length();
        if((len - maxCount) + 1 < maxCount){
            return stringBuilder.toString();
        }

        char last = ' ';
        while (maxCount > 0){
            for(int i = 0 ; i < arr.length ; i++){
                if(arr[i]  == maxCount){
                    char v  = (char) (i + 'a');
                    if(last != v){
                        stringBuilder.append( v);
                        last = v;
                        arr[i]--;
                    }else {
                        last = findChar(stringBuilder,i,arr,last);
                        if(last == ' '){
                            return "";
                        }
                    }
                }
            }
            maxCount--;
        }

        return stringBuilder.toString();
    }


    public static char findChar(StringBuilder stringBuilder ,int index,int[] arr,char last){
        int index1 = index;
        char last1 = last;
        index = 0;
        while (index < arr.length ){
            if(index == index1 || arr[index] == 0){
                index ++;
                continue;
            }
            char v  = (char) (index + 'a');
            stringBuilder.append(v).append(last);
            last = v;
            arr[index]--;
            arr[index1]--;
            break;
        }
        return last == last1 ? ' ' : last1;
    }


    /**
     * 基于最大堆的贪心算法 todo  767 好好分析下 堆和计数的贪心算法吧
     * @param S
     * @return
     */
    public static String reorganizeString1(String S) {

        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>(new Comparator<Character>() {
            public int compare(Character letter1, Character letter2) {
                return counts[letter2 - 'a'] - counts[letter1 - 'a'];
            }
        });
        for (char c = 'a'; c <= 'z'; c++) {
            if (counts[c - 'a'] > 0) {
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while (queue.size() > 1) {
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a', index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if (counts[index1] > 0) {
                queue.offer(letter1);
            }
            if (counts[index2] > 0) {
                queue.offer(letter2);
            }
        }
        if (queue.size() > 0) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }


    /**
     * 基于计数的贪心算法
     * @param S
     * @return
     */
    public static String reorganizeString2(String S) {

        if (S.length() < 2) {
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            counts[c - 'a']++;
            maxCount = Math.max(maxCount, counts[c - 'a']);
        }
        if (maxCount > (length + 1) / 2) {
            return "";
        }
        char[] reorganizeArray = new char[length];
        int evenIndex = 0, oddIndex = 1;
        int halfLength = length / 2;
        for (int i = 0; i < 26; i++) {
            char c = (char) ('a' + i);
            while (counts[i] > 0 && counts[i] <= halfLength && oddIndex < length) {
                reorganizeArray[oddIndex] = c;
                counts[i]--;
                oddIndex += 2;
            }
            while (counts[i] > 0) {
                reorganizeArray[evenIndex] = c;
                counts[i]--;
                evenIndex += 2;
            }
        }
        return new String(reorganizeArray);
    }

}
