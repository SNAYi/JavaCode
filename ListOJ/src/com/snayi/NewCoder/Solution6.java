package com.snayi.NewCoder;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-28 10:16
 * @Description: 以x为基准分割链表，小于x的放在前面，最后返回新的头节点，不能改变原有顺序
 *                  注意，要把大于x的链表最后一个节点的next置空，防止和原链表粘连起来
 */

public class Solution6 {
    public ListNode partition(ListNode pHead, int x) {
        if (pHead == null || x <= 0) {
            return null;
        }
        //创建两个虚拟头，一个存放小于x的值，另一个存放大于等于x的值
        ListNode sHeader = new ListNode(-1);
        ListNode bHeader = new ListNode(-1);
        ListNode sCur = sHeader;
        ListNode bCur = bHeader;
        //只要原链表不为空，就一直迭代
        while (pHead != null) {
            //小于x的链在sHeader为头的链表上
            if (pHead.val < x) {
                sCur.next = pHead;
                sCur = sCur.next;
            } else {    //大于等于x的链在bHeader为头的链表上
                bCur.next = pHead;
                bCur = bCur.next;
            }
            pHead = pHead.next;
        }
        //全部链完后需要将bCur与原链表断开
        bCur.next = null;
        //小的和大的接上
        sCur.next = bHeader.next;
        //返回小的的头节点
        return sHeader.next;
    }
}
