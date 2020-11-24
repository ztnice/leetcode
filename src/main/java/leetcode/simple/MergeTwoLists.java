package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/23
 */

public class MergeTwoLists {


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1,new ListNode(2,new ListNode(4)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4)));

        ListNode l = mergeTwoLists(l1,l2);
        System.out.println(l);


//        StringBuilder stringBuilder = new StringBuilder();
//        StringBuilder stringBuilder1 = stringBuilder;
//        stringBuilder1.append("aaa");
//
//        stringBuilder1.deleteCharAt(1);
//        System.out.println(stringBuilder);
//        System.out.println(stringBuilder1);


    }
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }

        ListNode node = new ListNode(1);

        ListNode lastedNode = node;
        while (l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                int val1 = l1.val;
                int val2 = l2.val;
                if(val1 <= val2){
                    lastedNode.next = l1;
                    l1 = l1.next;

                }else {
                    lastedNode.next = l2;
                    l2 = l2.next;

                }
                lastedNode = lastedNode.next;
                continue;
            }
            if(l1 != null){
                lastedNode.next = l1;
                l1 = l1.next;

            }
            if(l2 != null){
                lastedNode.next = l2;
                l2 = l2.next;
            }
            lastedNode = lastedNode.next;

        }
        return node.next;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
