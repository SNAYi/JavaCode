public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	 ListNode head = new ListNode(0);//定义一个虚拟头结点
	ListNode r = head;
	while(l1!=null&&l2!=null){
		if(l1.val>=l2.val){
			r.next=l2;
			r=l2;
			l2=l2.next;
		}else{
			r.next=l1;
			r=l1;
			l1=l1.next;
		}
	}
	if(l1!=null){
		r.next=l1;
	}
	if(l2!=null){
		r.next=l2;
	}
	return head.next;
}