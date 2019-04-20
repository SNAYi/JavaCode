public ListNode partition(ListNode pHead, int x) {
	ListNode beforeHead = null;
	ListNode beforeTail = null;
	ListNode afterHead = null;
	ListNode afterTail = null;
	ListNode cur = pHead;
	while (cur != null) {
		//防止内存泄漏
		ListNode curNext = cur.next;
		cur.next = null;
		if (cur.val < x) {
			//第一次插入,用尾插法
			if (beforeHead == null) {
				beforeHead = cur;
				beforeTail = cur;
			} else {            //不是第一次插入
				//连接起来
				beforeTail.next =cur;
				//尾巴后移
				beforeTail = cur;
			}
		} else {
			if (afterHead == null) {
				afterHead = cur;
				afterTail = cur;
			} else {
				afterTail.next = cur;
				afterTail = cur;
			}
		}

		cur = curNext;
	}
	//连接前先判断是否为空
	//都是大于X的数据,
	if (beforeHead == null) {
		return afterHead;
	}
	//两个连接起来
	beforeTail.next =afterHead;
	return beforeHead;
}