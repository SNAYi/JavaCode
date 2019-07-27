package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-27 21:09
 * @Description: 给一个非空链表，找中间节点 做法：快慢指针，先处理只有头节点情况=【
 */
public class Solution3 {
    public ListNode middleNode(ListNode head) {
        if(head.next == null) { //只有一个节点
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;  //到这里已经可以判断head.next肯定不为空
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //走到这里已经找到中间节点地前一个节点slow
        return slow.next;
    }
}
