package leetcode.simple;

/**
 * @author haozt
 * @since 2020/11/27
 */
public class DeleteNode {

    public static void main(String[] args) {

        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        listNode1.next = listNode2;
        listNode2.next  = listNode3;
        listNode3.next = listNode4;
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;
        deleteNode(listNode1);
        System.out.println(listNode1);

    }


    /**
     * 删除链表的中间节点
     * @param node
     */
    public static void deleteNode(ListNode node) {

        //先找出 中间节点  使用双指针法
        /**
         * 1.定义快慢指针 快指针每次移动2个单位 慢指针移动1个单位
         * 2.当快指针无法继续移动2个单位时，慢指针所在的位置 即为中间节点
         * 3.删除中间节点
         */
        ListNode slow = node;
        ListNode fast = node;
        ListNode slowPre = slow;
        while (fast != null){
            if(fast.next == null){
                break;
            }else {
                fast = fast.next;
                if(fast.next == null){
                    break;
                }
                slowPre = slow;
                slow = slow.next;
                fast = fast.next;
            }

        }

        slowPre.next = slow.next;
    }


    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
