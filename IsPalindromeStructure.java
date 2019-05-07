/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/7 下午 04:34
 */


public class IsPalindromeStructure {

    public class ListNode {
        int val;
        ListNode next = null;

            ListNode(int val) {
                this.val = val;
            }
        }
    /**
     *快慢指针法
     * @param A :the head
     * @return is or not a palindrome structure
     */
    public boolean chkPalindrome(ListNode A) {
        //1.判断A的合法性
        if (A == null) {
            return false;
        } else if (A.next == null) {
            return true;
        }
        ListNode fast = A;
        ListNode slow = A;
        //让fast slow 走到指定位置
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode prev = slow.next;
        ListNode prevNext = prev.next;
        //让next指向反转 方面从两边向中间比较
        while (prev != null) {
            prev.next = slow;
            slow = prev;
            prev = prevNext;
            if (prevNext != null) {
                prevNext = prevNext.next;
            }
        }
        while (A != slow) {
            //如果两个在没相遇前已经不相等，则肯定不是回文
            if (A.val != slow.val) {
                return false;
            }
            //如果只有两个节点，则一定是回文
            if (A.next == slow) {
                return true;
            }
            A = A.next;
            slow = slow.next;
        }
        return true;
    }
}
