/**
 * @Author: snayi
 * @CreateTime: 2019-08-21 15:33
 * @Description:  删除链表中值为val的所有节点  思路：遍历链表，遇到相等的就删除  或遇到不相等的就移到新链表
 *
 * 针对头节点的特殊性三种处理方法:
 *
 */
public class Solution {
    /**忽略第一个节点，先解决后面，最后特殊处理
     *
     * @param head
     * @param val
     */
    public Node test(Node head,int val){
        /**
         * cur 指向下一个待比较的节点
         * pre 永远指向待比较节点的前驱
         */
        Node cur = head.next;
        Node pre = head;
        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
            } else {
                pre = cur;  //只有当待比较节点的val不等于val时，才将pre后移一个
            }
            cur = cur.next;
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }
    public Node removeAllNode1(Node head,int val) {
        /**
         * 新链表的头节点
         */
        Node newHead = new Node(-1);
        /**
         * 始终指向新链表的最后一个节点
         */
        Node newCur = newHead;
        /**
         * head指向下一个待比较的节点
         */
        while (head != null) {
            if (head.val != val) {  //当前节点的val不等于val
                newCur.next = head;
                newCur = newCur.next;
            }
            head = head.next;
        }
        //需要特殊处理新链表的最后一个节点的next
            //因为如果新链表的最后一个节点的next还在指向原来的链表
        newCur.next = null;
        return newHead.next;
    }


    public Node reverseList(Node head) {
        Node newHead = null;
        Node cur = head;
        while(cur != null) {
            Node curNext = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = curNext;
        }
        return newHead;
    }
    public Node reverseList2(Node head) {
        Node cur = head;
        Node pre = null;
        while(cur != null) {
            Node curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        return pre;
    }
}
