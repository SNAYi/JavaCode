/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/8 下午 08:55
 */

public class SearchTheCommonNode {
      public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
     }
  }

    /**
     * 编写一个程序，找到两个单链表相交的起始节点。如果没有相交节点，返回0
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //1.校验合法性
        if (headA == null || headB == null) {
            return null;
        }
        //一开始默认headA链表比headB链表长
        ListNode curL = headA;
        ListNode curS = headB;
        //2.判断哪个链表长
        int countA = 0;
        int countB = 0;
        while (curL != null) {
            countA++;
            curL = curL.next;
        }
        while (curS != null) {
            countB ++;
            curS = curS.next;
        }
        int length = countA - countB;
        //3.让curL指向长的链表的head,然后两个cur位置到达同意起跑线
        //3.1如果B链表长，则让curL指向B链表;
        if (length < 0) {
            curL = headB;
            curS = headA;
            length = countB - countA;
        }
        //3.2然后让curL走到和curS距离相交节点相同的位置
        for (int i = 0; i < length; i++) {
            curL = curL.next;
        }
        //4.到达同意起跑线后，开始遍历两个链表，走到相遇节点跳出。
        while (curL !=null && curS != null && curL != curS) {
                curL = curL.next;
                curS = curS.next;
        }
        //返回相遇节点
        if (curL !=null && curS != null && curL == curS) {
            return curL;
        }
        return null;
    }
    //自己想法写的，有问题
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //1.校验合法性
        if (headA == null || headB == null) {
            return null;
        }
        //一开始默认headA链表比headB链表长
        ListNode curL = headA;
        ListNode curS = headB;
        //2.判断哪个链表长
        int countA = 0;
        int countB = 0;
        while (curL != null) {
            countA++;
            curL = curL.next;
        }
        while (curS != null) {
            countB ++;
            curS = curS.next;
        }
        //3.让curL指向长的链表的head,然后两个cur位置到达同意起跑线
        //3.1如果B链表长，则让curL指向B链表;
        if (countA < countB) {
            curL = headB;
            curS = headA;
            //3.1.1然后让curL走到和curS距离相交节点相同的位置
            while (countB - countA != 0 && curL != null) {
                curL = curL.next;
            }
        } else { //3.2 A链表长，cur重新指回head
            curL = headA;
            curS = headB;
            //3.2.1 同3.1.1
            while (countA - countB != 0 && curL != null) {
                curL = curL.next;
            }
        }
        //4.到达同意起跑线后，开始遍历比较节点值是否相等，相等则跳出返回相遇节点。遍历完还找不到返回null
        while (curL !=null && curS != null) {
            if (curL == curS) {
                return curL;
            } else {
                curL = curL.next;
                curS = curS.next;
            }
        }
        return null;
    }
}

