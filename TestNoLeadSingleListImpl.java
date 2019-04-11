// 1、无头单向非循环链表实现
public interface ILinked {
    //头插法
    void addFirst(int data);

    //尾插法
    void addLast(int data);

    //任意位置插入,第一个数据节点为0号下标
    boolean addIndex(int index,int data);

    //查找是否包含关键字key是否在单链表当中
    boolean contains(int key);

    //删除第一次出现关键字为key的节点
    int remove(int key);

    //删除所有值为key的节点
    void removeAllKey(int key);

    //得到单链表的长度
    int getLength();

    void display();

    void clear();
}



//不带头非循环单链表
public class NoLeadSingleListImpl implements ILinked {
    //1.单链表得有节点,成员内部类
    class Node{
        private int data;
        //指向下一个节点，next要是Node类型
        private Node next;
        //构造器要构造节点，得有数据
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //2.单链表得有头节点
    private  Node head;
    public NoLeadSingleListImpl(){
        this.head = null;
    }
    @Override
    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        //链表为空，第一次插入数据
        if(this.head ==null) {
            this.head = node;
        } else{
            node.next = this.head;
            this.head =node;
        }


    }

    @Override
    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        //定义一个临时遍历找尾节点
        Node cur =this.head;
        //第一次插入
        if(cur == null) {
            this.head = node;
        } else {
            while(cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    //找到要插入位置的前驱，找之前先判断合法性
    //往index位置放要走index-1 步，走到它的前驱位置
    private Node searchIndexPre(int index) {
        checkIndex(index);
        if(index == 0) {
            return null;
        }
        //记录走的步数
        int count = 0;
        Node cur = this.head;
        while(cur.next != null && count< index -1) {
            cur= cur.next;
            count ++;
        }
        return  cur;
    }
    //判断index合法性
    private void checkIndex(int index) {
        if (index < 0 || index >getLength()) {
            throw new IndexOutOfBoundsException("下标不合法");
        }
    }
    @Override
    //任意位置插入,第一个数据节点为0号下标
    //1.判断index合法性
    // 2.找到要插入位置的前驱
    public boolean addIndex(int index, int data) {
        Node node = new Node(data);
        Node pre =searchIndexPre(index);
        if(pre == null){
            //addFirst(data);
            node.next = this.head;
            this.head = node;
        } else {
            //先绑后面，再绑前面
            node.next = pre.next;
            pre.next = node;
        }
        return true;
    }

    @Override
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
         Node cur =this.head;
         while(cur != null) {
             if(cur.data ==key){
                 return true;
             }
             cur = cur.next;
         }
        return false;
    }

    private Node searchPre(int key) {
        Node pre =this.head;
        //1.判断是不是头节点
        if(pre.data == key) {
            return this.head;
            //return null;
        }
        while(pre.next != null ){
            if(pre.next.data == key){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    @Override
    //删除第一次出现关键字为key的节点
    public int remove(int key) {
        //if(head.data ==key)
        int oldData = 0;
        Node pre = searchPre(key);
        if(pre == null) {
            return -1;
        }
        if(pre.equals(this.head) && pre.data == key ){
            oldData = this.head.data;
            this.head = this.head.next;
            return oldData;
        }
        Node delNode = pre.next;
        pre.next = delNode.next;
        return oldData;
    }

    @Override
    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node pre = this.head;
        Node cur = this.head.next;
        while(cur != null) {
            if(cur.data ==key) {
                pre.next = cur.next;
                cur = cur.next;
            }  else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
    }

    @Override
    //得到单链表的长度,返回的是节点的个数
    public int getLength() {
        Node cur = this.head;
        int count = 0;
        while(cur != null) {
            count++;
            cur = cur.next;
        }
        return count;
    }

    @Override
    //定义一个cur变量，cur不为空，打印cur.data cur后移
    // 从头往后走打印，到尾节点停下
    public void display() {
        Node cur = this.head;
        while(cur != null) {
            System.out.print(cur.data +" " );
            cur = cur.next;
        }
        System.out.println();
    }

    @Override
    public void clear() {
        //头不为空，证明链表不为空
        while (this.head != null) {
            Node cur = this.head.next;
            this.head = null;
            head = cur;
        }
    }
}


public class TestNoLeadSingleListImpl {
    public static void main(String[] args) {
        NoLeadSingleListImpl noLeadSingleList = new NoLeadSingleListImpl();
        noLeadSingleList.addFirst(18);
        noLeadSingleList.addFirst(78);
        noLeadSingleList.addFirst(19);//99 78 18
        noLeadSingleList.addIndex(1,88);//99 88 78 18
        noLeadSingleList.addIndex(0,18);// 18 99 88 78 18
        noLeadSingleList.addLast(100);
        noLeadSingleList.display();
        System.out.println(noLeadSingleList.getLength());//5
        System.out.println(noLeadSingleList.contains(178));//true
        noLeadSingleList.remove(88);
        noLeadSingleList.display();
        noLeadSingleList.remove(19);
        noLeadSingleList.display();
        noLeadSingleList.removeAllKey(18);
        noLeadSingleList.display();
        System.out.println("===========");
        noLeadSingleList.clear();
        noLeadSingleList.display();
        System.out.println("===========");
    }
}
