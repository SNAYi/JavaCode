/**
 * @Author: snayi
 * @CreateTime: 2019-07-26 22:59
 * @Description:
 */
public class TestSequence {
    public static void main(String[] args) {
        Sequence sequence = new SequenceImpl();
        for (int i = 0; i <10 ; i++) {
            sequence.add(i,i);
        }
        //扩容成功
        sequence.add(10,10);
        //Object可以放任意类型的数
        sequence.add(11,"诶嘿诶嘿");
        sequence.display();
        //测romove的同时测试了search,
        sequence.remove(3);
        sequence.display();
        System.out.println("sequence的size是：" + sequence.size());
        System.out.println(sequence.getPos(5));
        System.out.println("========");
        sequence.clear();
        sequence.display();
        System.out.println("========");
    }
}
