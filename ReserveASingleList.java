/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/5 下午 07:14
 */


public class ReserveASingleList {


    public static void main(String[] args) { }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    /**
     * 利用一个临时链表只返回一个头节点
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5
     */

    public ListNode reverseList1(ListNode head) {
        ListNode pre = head;
        ListNode cur = head;
        ListNode newHead = null;
        while (cur != null) {
            cur = cur.next;
            if (newHead == null) {
                newHead = pre;
            } else {
                newHead.next = newHead;
                newHead = pre;
            }
            pre = cur;
        }
        return newHead;
    }

    /**
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        ListNode returnHead = null;
        while (cur != null) {
            ListNode curNext = cur.next;
            if (curNext == null) {
                returnHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return  returnHead;
    }
    //更简洁易懂版本
    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode curNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curNext;
        }
        return prev;
    }

    }
