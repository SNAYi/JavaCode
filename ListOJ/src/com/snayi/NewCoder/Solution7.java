package com.snayi.NewCoder;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-28 10:38
 * @Description:
 */
public class Solution7 {
    public ListNode deleteDuplication(ListNode pHead)
    {
        if(pHead == null) {
            return pHead;
        }
        //新建一个链表将不重复节点串起来，最后返回这个新链表
        ListNode header = new ListNode(-1);
        ListNode cur = header;
        while(pHead != null) {
            if(pHead.next != null && pHead.val == pHead.next.val) {
                while(pHead.next != null && pHead.val == pHead.next.val) {
                    pHead = pHead.next;
                }
                pHead = pHead.next;
                cur.next = pHead;
            } else{
                cur.next = pHead;
                cur = cur.next;
                pHead = pHead.next;
            }
        }
        return header.next;
    }
}
