/**
 * @auther SNAYi
 *@describe Input a linked list, the output of the linked list in the last k node
 * @date 2019/5/5 下午 08:37
 */


public class ReturnTheBottomKNode {
    public static void main(String[] args) {
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }

        public ListNode FindKthToTail(ListNode head, int k) {
            //判断合法性
            if (head == null ||k <= 0) {
                return null;
            }
            ListNode fast = head;
            ListNode slow = head;
            //先让fast走k-1步
            while (k - 1 != 0) {
                if (fast.next != null) {
                    fast = fast.next;
                    k--;
                } else {
                    return null;
                }
            }
            //两者一起走
            //这里需要判断的是fast.next，如果判断fast，slow最后走到的就是要找的节点的下一个了
            while (fast.next != null) {

                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
