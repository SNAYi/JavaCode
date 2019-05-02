public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	if (headA == null || headB == null)
	return null;

	int headALength = 0;
	int headBLength = 0;

	ListNode pL = headA;
	ListNode pS  = headB;

	while (pL != null){
		++headALength;
		pL = pL.next;
	}

	while (pS != null){
		++headBLength;
		pS = pS.next;
	}

	int myLen = headALength-headBLength;
	if(myLen < 0) {
		pL = headB;
		pS = headA;
		myLen = headBLength-headALength;
	}
	
	for(int i = 0;i < myLen;i++){
		 pL = pL.next;
	}
	
	while(pL != null && pS!=null && pL != pS){
		pL = pL.next;
		pS = pS.next;
	}
	if(pL == pS && pL != null && pS!=null){
		return pL;
	}
	return null;
}