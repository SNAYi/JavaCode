/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/6 下午 09:27
 */

public class DeleteTheRepeatNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        /**
         * 思路：将不重复的节点串到另一个链表，最后返回另一个链表即可
         * 注意：可以不设置原链表的遍历节点cur，直接用pHead遍历即可
         * @param pHead
         * @return
         */
    public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null) {
                return pHead;
            }
            //用来标志新链表的头节点，方便最后给返回值
            ListNode newHead = new ListNode(-1);
            //newHead链表的遍历节点
            ListNode cur1 = newHead;
            while (pHead != null) {
                if (pHead.next != null && pHead.val == pHead.next.val) {
                    while (pHead.next != null && pHead.val == pHead.next.val) {
                        pHead =pHead.next;
                    }
                    pHead = pHead.next;
                    //此处虽然把重复的节点加进了新链表，但是最后覆盖掉了因为cur1位置没变
                    cur1.next = pHead;
                } else {
                    cur1.next =pHead;
                    cur1 = cur1.next;
                    pHead =pHead.next;
                }
            }
            return newHead.next;
    }
    }
}
