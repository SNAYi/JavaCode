package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-29 10:03
 * @Description: 环形链表  判断链表是否有环，有环返回入环点
 */
public class Solution10 {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow)    //相遇
                return true;
        }
        return false;
    }
}
