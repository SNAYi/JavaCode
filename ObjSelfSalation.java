public class ObjSelfSalation {
	public static ObjSelfSalation test;
	
	public void isAlive() {
		System.out.println("I am alive :)");
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize method executed!");
		test = this;
	}
	
	public static void main(String[] args)throws Exception {
		test = new ObjSelfSalation();
		test = null;
		System.gc();
		Thread.sleep(500);
		if (test != null) {
			test.isAlive();
		}else {
			System.out.println("no,I am dead :(");
		}
		// 下main代码与上面完全⼀致，但是此次自救失败
		test = null;
		System.gc();
		Thread.sleep(500);
		if (test != null) {
			test.isAlive();
		}else {
			System.out.println("no,I am dead :(");
		}
	}
}