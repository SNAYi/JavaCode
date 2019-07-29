package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-29 10:25
 * @Description:
 */
public class Solution11 {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode detectCycle(ListNode head) {
            //判断是否有环
            ListNode res = hasCycle(head);
            //没环直接返回null
            if(res == null) {
                return null;
            }
            //将slow指针拉回头
            ListNode slow = head;
            //然后fast和slow一起走，如果相遇，相遇处就是入环的第一个结点
            while(res != slow) {
                res = res.next;
                slow = slow.next;
            }
            if(res == slow) {
                return res;
            }
            return res;
        }
        //判断是否有环
        private ListNode hasCycle(ListNode head) {
            if(head == null ||head.next == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;
            while(fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if(fast == slow) {
                    return fast;
                }
            }
            return null;
        }
    }
}

