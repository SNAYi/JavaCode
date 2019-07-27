package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-27 22:06
 * @Description: 合并两个有序链表
 *                  新建一个虚拟头节点，把这两个链表串起来
 */
public class Solution5 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        //这里走完还没有完全串起来，如果一个已经串完了，另一个也就停了
        while(l1 != null && l2 !=null) {
            if(l1.val <= l2.val) {
                cur.next = l1;
                cur = cur.next;
                l1 = l1.next;
            } else{
                cur.next = l2;
                cur =cur.next;
                l2 = l2.next;
            }
        }
        //如果l1完了，cur后面接l2
        if(l1 == null){
            cur.next = l2;
        }
        //如果l2完了，cur后面接l1
        if(l2 == null) {
            cur.next = l1;
        }
        return header.next;
    }
}
