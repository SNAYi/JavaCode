public ListNode detectCycle(ListNode head) {
	ListNode fast = head;
	ListNode slow = head;
	while(fast != null && fast.next != null){
		fast = fast.next.next;
		slow = slow.next;
		if(fast == slow){
			break;
		}
	}
	if(fast == null || fast.next == null){
		return null;
	}
	slow = head;//此时一人一部走
	while(fast != slow){
		fast = fast.next;
		slow = slow.next;
	}
	if(fast == slow){
		return slow;
	}
	return null;
}