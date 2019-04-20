class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
}
public ListNode FindKthToTail(ListNode head,int k) {
	//校验给的数据合法性
	ListNode cur = head;
	int count = 0;
	while (cur != null) {
		count++;
		cur = cur.next;
	}
	if (head == null || k <= 0 || k > count) {
		return null;
	}
	ListNode fast = head;
	ListNode slow = head;
	//出来后发fast就走到了指定位置
	while (k - 1 > 0) {
		fast = fast.next;
		k--;
	}
	while(fast.next !=null){
		fast =fast.next;
		slow =slow.next;
	}
	return slow;
}