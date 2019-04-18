public class TestException {
    public static void main(String[] args) {
        System.out.println("1.数学运算开始前");
        //1.ArithmeticException
//        int x = Integer.parseInt("1");
//        int y = Integer.parseInt("0");

        //2.NumberFormatException
//        int x = Integer.parseInt("1");
//        int y = Integer.parseInt("str");
        
        //3. ArrayIndexOutOfBoundsException
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        try {
            System.out.println("2.进行数学运算的结果: " + (x/y));
        } catch (ArithmeticException e) {
            System.out.print("3.取得异常完整信息： ");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
            System.out.println("4.不管是否产生异常,都会走出口，执行这一步");
        }
    }
}