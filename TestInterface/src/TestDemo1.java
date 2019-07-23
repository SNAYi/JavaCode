/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 19:40
 * @Description: 父接口通过共同子类相互转换
 */
interface IMessage{
    public static final String MSG ="java";
    public abstract void print();
}

interface INews{
    public abstract void getMsg();
}

class MessageImpl implements IMessage,INews{
    public void print() {
        System.out.println(MSG);
    }
    public void getMsg() {
        System.out.println(MSG);
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        //new MessageImpl,但是是IMessage的对象
        //只能使用IMessage定义的方法
        IMessage msg = new MessageImpl();
        msg.print();
        //INews news = new MessageImpl();
        //父接口的相互转换
        INews news = (INews) msg;
        news.getMsg();
    }
}

