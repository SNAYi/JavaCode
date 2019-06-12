importjava.io.BufferedReader;
importjava.io.IOException;
importjava.io.InputStreamReader;

public class NicochesTheorem{
	public static void main(String[]args)throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String s;
		while((s=bf.readLine())!=null){
			long m = Integer.valueOf(s);
			long a = m*m-m+1;	//计算首项
			System.out.print(a);
				for(inti=1;i<m;i++){//继续等差数列求和
					System.out.print("+"+(a+=2));
				}
			System.out.println();
		}
		bf.close();
	}
}