import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        while(in.hasNext()) {
            int n = in.nextInt();
            String[] s = new String[n];
            for(int i = 0;i < n;i++) {
                s[i] = in.nextLine();
            }
            for (int i = 0; i < n; i++) {
                if (s[i].startsWith("1")) {
                    list.add(Long.parseLong(s[i].substring(1)));
                }
                if (s[i].startsWith("2")) {
                    list.remove(Long.parseLong(s[i].substring(1)));
                }
                formPolygon(list);
            }
        }

    }
    public static String formPolygon(List<Long> list) {
        int len = list.size();
        if (len < 2) {
            return "NO";
        } else {
            //1.对list进行排序
            Collections.sort(list);
            //拿到最大值
            long max = list.get(len-1);
            //拿到整个list的和
            long sum = 0;
            for (long temp:list) {
                sum +=temp;
            }
            if (max < sum-max) {
                return "YES";
            }
        }
        return "NO";
    }
}

