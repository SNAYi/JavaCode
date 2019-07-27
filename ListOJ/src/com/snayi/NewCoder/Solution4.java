package com.snayi.NewCoder;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-27 21:19
 * @Description: 找到倒数第K个节点，快慢指针法
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
public class Solution4 {
    public ListNode FindKthToTail(ListNode head, int k) {
        //判断合法性
        if (head == null || k <= 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        //出来之后fast就走到对应位置了
        while (k - 1 != 0) {
            if (fast.next != null) {
                fast = fast.next;
                k--;
            } else {
                return null;
            }
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    }
}


