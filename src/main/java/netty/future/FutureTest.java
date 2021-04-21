package netty.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author zhangjinchun
 * @date 2021/3/16
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程池
        ExecutorService executor = Executors.newCachedThreadPool();
        Future future = executor.submit(new Task());
        //这一步get会阻塞当前线程
        System.out.println(future.get());

        executor.shutdown();
    }

    private static class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            System.out.println("子线程在进行计算");
            Thread.sleep(5000);
            return 1;
        }

    }
}
