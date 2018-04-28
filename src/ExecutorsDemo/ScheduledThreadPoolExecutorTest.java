package ExecutorsDemo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by zhuhe on 2018/4/27.
 */
public class ScheduledThreadPoolExecutorTest {

    public static void main(String[] args) throws InterruptedException {
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        ScheduledThreadPoolExecutor pool = new ScheduledThreadPoolExecutor(5);
//
//        for (int i = 0; i < 5; i++) {
//            final int temp = i + 1;
//            pool.schedule(() -> {
//                System.out.println("第" + temp + "个炸弹爆炸时间:" + simpleDateFormat.format(new Date()));
//            }, temp * 5, TimeUnit.SECONDS);
//        }
//        pool.shutdown();
//        System.out.println("end main时间:" + simpleDateFormat.format(new Date()));

        try {
            scheduleAtFixedRate();
//            scheduleRunable();
//            scheduleCaller();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }


    // 任务间以固定时间间隔执行，延迟1s后开始执行任务，任务执行完毕后间隔2s再次执行，任务执行完毕后间隔2s再次执行，依次往复
    static void scheduleWithFixedDelay() throws InterruptedException, ExecutionException {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

        ScheduledFuture<?> result = executorService.scheduleWithFixedDelay(new Runnable() {
            public void run() {

                System.out.println(System.currentTimeMillis());

            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        // 由于是定时任务，一直不会返回
        result.get();
        System.out.println("over");
        executorService.shutdown();
    }


    // 相对开始加入任务的时间点固定频率执行：从加入任务开始算1s后开始执行任务，1+2s开始执行，1+2*2s执行，1+n*2s开始执行；
    // 但是如果执行任务时间大约2s则不会并发执行后续任务将会延迟。

    static void scheduleAtFixedRate() throws InterruptedException, ExecutionException {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

        ScheduledFuture<?> result = executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {

                System.out.println(System.currentTimeMillis());

            }
        }, 1000, 2000, TimeUnit.MILLISECONDS);

        // 由于是定时任务，一直不会返回
        result.get();
        System.out.println("over");
    }

    // 延迟1s后开始执行，只执行一次，没有返回值
    static void scheduleRunable() throws InterruptedException, ExecutionException {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

        ScheduledFuture<?> result = executorService.schedule(new Runnable() {

            @Override
            public void run() {
                System.out.println("gh");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }, 1000, TimeUnit.MILLISECONDS);

        System.out.println(result.get());
        executorService.shutdown();
    }

    // 延迟1s后开始执行，只执行一次，有返回值
    static void scheduleCaller() throws InterruptedException, ExecutionException {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(10);

        ScheduledFuture<String> result = executorService.schedule(new Callable<String>() {

            @Override
            public String call() throws Exception {

                try {
                    System.out.println("call init");
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                return "gh";
            }

        }, 1000, TimeUnit.MILLISECONDS);

        // 阻塞，直到任务执行完成
        System.out.print(result.get());
        executorService.shutdown();
    }

}
