package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haozt
 * @since 2020/10/13
 */
public class AddTwoNumbers {

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */


    public static void main(String[] args) {

        AddTwoNumbers numbers = new AddTwoNumbers();

        ListNode l1 = numbers.new ListNode(9);
        ListNode listNode = numbers.new ListNode(9);
        ListNode listNode2 = numbers.new ListNode(9);
        l1.setNext(listNode);
        listNode.setNext(listNode2);



        ListNode l2 = numbers.new ListNode(9);
        ListNode listNode3 = numbers.new ListNode(9);
        ListNode listNode4 = numbers.new ListNode(9);
        ListNode listNode5 = numbers.new ListNode(9);
        l2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        ListNode listNode1  = numbers.addTwoNumbers1(l1,l2);

        System.out.println(listNode1);

    }


    class ListNode{

        private int val;

        private ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }


    /**
     *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *  输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     */
    public  ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        int val1 = l1.val;
        int val2 = l2.val;
        list1.add(val1);
        list2.add(val2);
        while (l1.next != null){
            l1 = l1.next;
            val1 = l1.val;
            list1.add(val1);
        }

        while (l2.next != null){
            l2 = l2.next;
            val2 = l2.val;
            list2.add(val2);
        }


        // 4 3 2 1  1 2 3

        int size1 = list1.size();
        int size2 = list2.size();
        int size = size1 > size2  ? size1 : size2;

        if(size > size1){
            for(int i = size - size1; i > 0;i--){
                list1.add(0);
            }
        }else {
            for(int i = size - size2; i > 0;i--){
                list2.add(0);
            }
        }


        int num = list1.get(0) + list2.get(0);

        int num1 = 0;

        if(num > 10){
            num = num % 10;
            num1 = 1;
        }
        ListNode listNode = new ListNode(num);
        for(int i = 1 ; i < size ;i++){

            num = list1.get(i) + list2.get(i) + num1;
            //进位
            if(num >= 10){
                num1 = 1;
                num = num % 10;
            }else {
                num1 = 0;
            }
            if(listNode.next == null){
                listNode.setNext(new ListNode(num));
            }else {
                ListNode currentNode = null;
                ListNode nextNode = listNode.next;
                while (nextNode != null){
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                    if(nextNode == null){
                        currentNode.setNext(new ListNode(num));
                    }
                }
            }

        }


        if(num1  != 0){
            ListNode currentNode = null;
            ListNode nextNode = listNode.next;
            while (nextNode != null){
                currentNode = nextNode;
                nextNode = nextNode.next;
                if(nextNode == null){
                    currentNode.setNext(new ListNode(num1));
                }
            }

        }
        return listNode;
    }



    public  ListNode addTwoNumbers1(ListNode l1, ListNode l2) {


        ListNode listNode = new ListNode(0);

        int jw = 0;//是否进位
        ListNode currentNode = null;
        while (l1 != null || l2 != null){
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int result = a + b +jw;
            jw = result / 10;
            int val = result % 10;
            int num = jw > 0 ?  val : result;
            ListNode nextNode = listNode.next;
            if(nextNode == null){
                listNode.next = new ListNode(num);
            }else {
                while (nextNode != null){
                    currentNode = nextNode;
                    nextNode = nextNode.next;
                    if(nextNode == null){
                        currentNode.next = new ListNode(num);
                    }
                }
            }

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }


        if(jw == 1){
            if(currentNode == null){
                currentNode = listNode.next;
                currentNode.next = new ListNode(jw);
            }else {
                ListNode node = currentNode.next;
                node.next =  new ListNode(jw);
            }

        }


        return listNode.next;
    }


}
