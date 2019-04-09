public class TestStringFun{
	public static void main1(String[] args) {
		String str = "hello";
		str += "World";
		str += "!!!";
		System.out.println(str); 
	}
	public static void main2(String[] args) {
		char[] data = new char[]{'h','e','l','l','o'};
		String str =new String(data);
		String str1 =new String(data,2,2);
		System.out.println(str);
		System.out.println(str1);
	}
	public static void main3(String[] args) {
		String str ="hello";
		char c = str.charAt(1);
		char[] data = str.toCharArray();
		System.out.println(c);//e
		System.out.println(data.length);//5
	}
	public static void main4(String[] args) {
		String str ="哈嘿哼哈";
		byte[] data = str.getBytes();//windows 默认编码jbk
		for(byte b : data)
			System.out.println(b);
	}
	public static void main5(String[] args) {
		String str ="hello";
		String str1 ="@@*hello!!";
		System.out.println(str.contains("ll"));//true
		System.out.println(str.indexOf("l"));//2
		System.out.println(str.lastIndexOf("l"));//3
		System.out.println(str1.startsWith("@"));//true
		System.out.println(str1.endsWith("!"));//true
	}
	public static void main6(String[] args) {
		String str ="s-b";
		str =str.replaceAll("s","*");
		str =str.replaceAll("b","*");
        System.out.println(str);//true
	}

}