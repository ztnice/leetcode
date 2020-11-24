package leetcode.medium;

import java.util.Arrays;

/**
 * @author haozt
 * @since 2020/11/20
 */
public class InsertionSortList {



    public static void main(String[] args) {

//        int[] arr = new int[1000];
//        for(int i = 1000 ; i > 0 ; i--){
//            arr[i-1] = i;
//        }
//
//        int[] a1 = insertSort1(arr);
//        int[] a = insertSort(arr);
//        System.out.println(Arrays.toString(a));
//        System.out.println(Arrays.toString(a1));


        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(3);
//        ListNode listNode3 = new ListNode(4);
//        ListNode listNode4 = new ListNode(0);
        listNode.next = listNode1;
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;

        ListNode node = insertionSortList1(listNode);
        System.out.println(node);

    }


    // 数组的插入排序  建议使用这种
    public static int[] insertSort(int[] arr){
        long a = System.currentTimeMillis();
        //插入排序
        for(int i = 1 ; i < arr.length ; i++){

            int j = i - 1;
            int key = arr[i];
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        long b = System.currentTimeMillis();

        System.out.println((b-a) + ":ms");
        return arr;

    }




    //数组的插入排序 这种消耗时间大 此种插入排序不可取
    public static int[] insertSort1(int[] arr){

        long a = System.currentTimeMillis();
        //插入排序
        for(int i = 1 ; i < arr.length ; i++){

            int j = 0;
            while (j < i){
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    j = i -1 ;
                    //将后面元素全部移位
                    while (j > 0){
                        arr[j+1] = arr[j];
                        j--;
                    }
                    arr[j+1] = temp;
                    break;
                }
                j++;
            }

        }

        long b = System.currentTimeMillis();

        System.out.println((b-a) + ":ms");
        return arr;
    }



    // 链表的插入排序
    public static ListNode insertionSortList(ListNode head) {

        if(head == null ){
            return null;
        }

        ListNode tempHead = new ListNode(0);
        tempHead.next = head;
        ListNode lastSortedNode  = head ,curr = head.next;

        while (curr != null){
            if(lastSortedNode.val <= curr.val){
                lastSortedNode  = lastSortedNode.next;
            }else {
                ListNode prev = tempHead;
                while (prev.next.val <= curr.val ){
                    prev = prev.next;
                }
                lastSortedNode.next = curr.next;
                curr.next  = prev.next;
                prev.next = curr;
            }
            curr = lastSortedNode.next;
        }
        return tempHead.next;
    }


    public  static ListNode insertionSortList1(ListNode head) {

        if(head == null){
            return null;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode sortedList = head;
        ListNode curr = head.next;
        while (curr != null){
            if(curr.val >= sortedList.val){
                sortedList = sortedList.next;
            }else {
               //node 跟curr进行比较
                // 0 -> 3 ->4 -> 1
                ListNode prev = node;
                while (prev.next.val <= curr.val){
                    prev = prev.next;
                }
                sortedList.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = sortedList.next;
        }

        return node.next;

    }






    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }


}
