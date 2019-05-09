/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/9 下午 08:09
 */


public class LinkedListCycleII {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
        public ListNode detectCycle(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            //1.判断是否有环
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (fast == slow) {
                    break;
                }
            }
            //空链表或单节点不成环
            if (fast == null || fast.next == null) {
                return null;
            }
            //2.找入环的第一个节点
            slow = head; //2.1先让slow回到头
            while (fast != slow) { //2.2 让两个指针同步走，走出循环就是相遇点
                fast = fast.next;
                slow = slow.next;
            }
            if (fast == slow) { //2.3 相遇点就是第一个入环点
                return slow;
            }
            return null;
        }
        }
}
