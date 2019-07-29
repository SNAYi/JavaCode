package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-28 18:17
 * @Description: 相交链表
 */
public class Solution9 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //判断合法性
        if(headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        int lengthA = 0;
        int lengthB = 0;
        //拿到AB链表长度
        while(curA != null) {
            lengthA++;
            curA = curA.next;
        }
        while(curB != null) {
            lengthB++;
            curB = curB.next;
        }
        int i = lengthA-lengthB;
        if(i < 0) { //headB长
            curA= headB;    //curA永远指向长的那个
            curB = headA;
            i = -i;
        } else {
            curA = headA;
            curB = headB;
        }
        //走出此循环后长链表cur和短链表cur长度相同
        while(i != 0 && curA.next != null) {
            curA = curA.next;
            i--;
        }
        //最后要返回的相遇节点
        ListNode result = null;
        while(curA != null && curB != null) {
            if(curA.val == curB.val) {
                result = curA;
                return result;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
