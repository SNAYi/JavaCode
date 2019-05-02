public boolean chkPalindrome(ListNode A) {
	if(A == null){
		return false;
	}else if(A.next == null){
		return true;
	}
	ListNode fast = A,slow = A;
	while(fast != null && fast.next != null){
		fast = fast.next.next;
		slow = slow.next;
	}
	ListNode p = slow.next;
	ListNode p1 = p.next;
	while(p != null){
		p.next = slow;
		slow = p;
		p = p1;
		if(p1!=null)
		p1 = p1.next;
	}
   while(A != slow){
	   if(A.val != slow.val){
		   return false;
	   }
	   if(A.next == slow){
		   return true;
	   }
	   A = A.next;
	   slow = slow.next;
   }
	return true;
}