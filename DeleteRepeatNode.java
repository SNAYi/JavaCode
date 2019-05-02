public ListNode deleteDuplication(ListNode pHead){
	ListNode head = new ListNode(-1);
	//代替head，串联存放不重复的节点
	ListNode tmpHead = head;
	
	ListNode cur = pHead;//用来遍历单链表
	
	while(cur != null){
		if(cur.next != null && cur.val == cur.next.val) {
			//说明找到了重复的，我们开始找到，第一个不重复的
			while(cur.next != null && cur.val == cur.next.val){
				cur = cur.next;
			}
			cur = cur.next;//跳过最后一个重复的节点
			tmpHead.next = cur;
		}else{
			tmpHead.next = cur;
			tmpHead = cur;
			cur = cur.next;
		}
	}
	return head.next;
}