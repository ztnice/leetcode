package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/30
 */
public class DeleteDuplicates {

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
//        ListNode node6 = new ListNode(3);

        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node6;

        ListNode listNode = deleteDuplicates1(node);

        System.out.println(listNode);

    }


    public static ListNode deleteDuplicates(ListNode head) {

        ListNode node = head;

        while (node != null && node.next != null){
            if(node.val == node.next.val){
                ListNode node1 = node.next;
                node.next = node1.next;
                node1.next = null;//help GC
            }else {
                node = node.next;
            }
        }
        return head;
    }


    /**
     * 链表的移出重复元素
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {

        //1->1->1->2
        ListNode current = head;
        while (current != null && current.next != null){
            ListNode node = current.next;
            if(current.val == node.val){
                current.next = node.next;
                node.next = null;//GC
            }else {
                current = current.next;
            }
        }
        return head;

    }


    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

}
