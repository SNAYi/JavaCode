/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/9 下午 07:20
 */


public class LinkedListCycle {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //如果链表为空，或者只有一个节点，就不走这个循环
        while (fast != null && fast.next != null) { //fast要走两步，所以要校验fast.next
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        //空链表或者一个节点，肯定没环
        if (fast == null || fast.next == null) {
            return false;
        } else{ //否则一定有环
            return true;
        }
    }
}
