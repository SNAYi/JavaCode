/**
 *
 */

/**
 * @auther SNAYi
 *@describe
 * @date 2019/5/6 下午 02:30
 */


public class SeperateSingleList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        /**
         *write by myself ,have some question?
         * @param pHead :list's head
         * @param x :Benchmark of segmentation
         * @return new list head
         * 分两个链表，一个放比x小的，一个放比x大的，最后两者拼接
         * 此种方法没有把原链表的next置空，所以需要在最后把比x大的链表的最后一个节点的next置空
         * 并且产生了两个标志头节点
         * 此链表的时间复杂度空间复杂度都比下一个方法要小，但是本质差别没有很大
         */
        public ListNode partition(ListNode pHead, int x) {
            ListNode cur = pHead;
            //1.校验数据合法性
            if (pHead == null || x < 0) {
                return null;
            }
            //beforeXHead放比x小的节点 beforeXTail
            //newHead2放比x大的节点
            ListNode newHead1 = new ListNode(-1);
            ListNode newHead2 = new ListNode(-1);
            ListNode cur1 = newHead1;
            ListNode cur2 = newHead2;
            while (cur != null) {
                if (cur.val < x) {
                    cur1.next = cur;
                    cur1 =cur1.next;
                } else {
                    cur2.next = cur;
                    cur2 =cur2.next;
                }
                cur = cur.next;
            }
            cur2.next = null;
            cur1.next = newHead2.next;
            return newHead1.next;
        }

        /**
         *此方法与上面方法大致思路相同
         * 但是此方法没有产生标志头节点，并且将原链表的next都置空了，防止代码出现问题
         *
         */
        public ListNode partition2(ListNode pHead, int x) {
            //1.合法性校验
            if (pHead == null || x < 0) {
                return null;
            }
            //2.将小于X的放在一个新链表，将大于X的放在另一个新链表。然后把大于的串在小于的后面
            ListNode smallHead = null;
            ListNode smallTail = null;
            ListNode bigHead = null;
            ListNode bigTail = null;
            while (pHead != null) {
                ListNode nextNode = pHead.next;
                pHead.next =null;
                if (pHead.val < x) {
                    //判断是否是第一次插入
                    if (smallHead == null) {
                        smallHead = pHead;
                        smallTail =smallHead;
                    } else {
                        smallTail.next = pHead;
                        smallTail =smallTail.next;
                    }
                } else {
                    if (bigHead == null) {
                        bigHead = pHead;
                        bigTail =bigHead;
                    } else {
                        bigTail.next = pHead;
                        bigTail = bigTail.next;
                    }
                }
                pHead = nextNode;
            }
            if (smallHead == null) {
                return bigHead;
            }
            smallTail.next = bigHead;   //两个链表头尾拼接
            return smallHead;
        }
    }
}
