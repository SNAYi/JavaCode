class BuildingAProductArray {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] b = new int[n];

        int temp =1;    //用来存放a[i]的乘积
        for(int i = 0;i < n;i++) {    //1.判断循环次数
            for(int j = 0;j < n;j++) {    //2.遍历相乘，得到b[i]值
                if(j == i) {
                    continue;
                } else {
                    temp *= A[j];
                }
            }
            b[i] = temp;
            temp = 1;
        }
        return b;
    }
}