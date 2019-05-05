/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/5 下午 10:06
 */


public class MergeOrderSingleList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    /**
     * newHead
     * @param l1 List1's head
     * @param l2 List2's head
     * @return  newList's newHead
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //1.define a virtual head mark head
        ListNode newHead = new ListNode(-1);
        ListNode cur = newHead;
        while (l1 != null && l2 !=null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 =l2.next;
                cur =cur.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return newHead.next;
    }
}
