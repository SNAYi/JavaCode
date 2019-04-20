class Solution {
    public ListNode removeElements(ListNode head, int val) {
        //加一个不动的头节点给-1 标志不存数据
        ListNode header = new ListNode(-1);
        //把头节点的数据保存下来最后返回回去
        header.next = head;
        //不希望动header，所以要再设一个副本来遍历
        ListNode cur = header;
        while(cur.next != null) {
            if(cur.next.val == val) {
                cur.next = cur.next.next; 
            } else {
                cur = cur.next;
            }
        }
        return header.next;
    }
}