package com.snayi.LeeCode;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-27 21:06
 * @Description:  移除链表中值为val的所有元素  使用一个虚拟头节点
 */
class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
class Solution1 {
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

