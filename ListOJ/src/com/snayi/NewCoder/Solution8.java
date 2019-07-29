package com.snayi.NewCoder;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-28 12:16
 * @Description: 判断链表是否回文
 */
public class Solution8 {
    public boolean chkPalindrome(ListNode A) {
        //1.验证合法性
        if(A == null) {
            return false;
        }
        if(A.next ==null) {    //只有一个结点
            return true;
        }
        ListNode slow = A;
        ListNode fast = A;
        while(fast != null && fast.next != null) {//让slow走到中间
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode pre = slow.next;
        ListNode preNext = pre.next;
        while(pre != null) {    //反转单链表
            pre.next = slow;
            slow = pre;
            pre = preNext;
            if(preNext != null) {
                preNext = preNext.next;
            }
        }
        while(A != slow) {  //没有相遇则一直比较
            //没相遇前已经有不等的，一定不是回文
            if(A.val != slow.val) {
                return false;
            }
            if (A.next == slow) {    //在这里需要考虑只有两个节点的特殊情况
                return true;
            }
                A = A.next;
                slow = slow.next;

        }
        return true;
    }
}
