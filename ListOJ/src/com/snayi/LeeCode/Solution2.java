package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-27 21:07
 * @Description: 用迭代法反转链表  使用三个节点 一个前驱 一个后继
 */
public class Solution2 {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = pre;	//cur.next先指向前驱，进行反转
            pre = cur;		//pre再后移到cur
            cur = curNext;	//cur再后移一位
        }
        return pre;
    }

}
