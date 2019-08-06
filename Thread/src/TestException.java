/**
 *
 */

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @auther SNAYi
 *@describe
 * @date 2019/6/7 下午 06:46
 */


public class TestException {
    public static void main(String[] args) {
        test();
        System.out.println(Runtime.getRuntime().availableProcessors());
/*        ExecutorService executorService = Executors.newScheduledThreadPool();
        ((ScheduledExecutorService) executorService).scheduleAtFixedRate()*/

    }
    public static int test() {
        try {
            return 1;
        } finally {
            return 2;
        }
    }
}
