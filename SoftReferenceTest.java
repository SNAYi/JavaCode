import java.lang.ref.SoftReference;
public class SoftReferenceTest {
    private static final int _1MB = 1024*1024;
    private byte[] data = new byte[2*_1MB];
    public static void main(String[] args) {
        SoftReferenceTest test = new SoftReferenceTest();
        SoftReference<SoftReferenceTest> softReference =
                new SoftReference<>(test);
        test = null;
        System.gc();
    }
}