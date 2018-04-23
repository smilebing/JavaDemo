package ExecutorsDemo;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuhe on 2018/4/19.
 */

/**
 * 延迟连接池
 */
public class DelayThreadPool {

    public void test() {
        //创建一个线程池，它可安排在给定延迟后运行命令或者定期地执行。
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(5);
//创建实现了Runnable接口对象，Thread对象当然也实现了Runnable接口
        Thread t1 = new MyThread();
        Thread t2 = new MyThread();
        Thread t3 = new MyThread();
        Thread t4 = new MyThread();
        Thread t5 = new MyThread();
//将线程放入池中进行执行
        pool.execute(t1);
        pool.execute(t2);
        pool.execute(t3);
//使用延迟执行风格的方法
        pool.schedule(t4, 10, TimeUnit.SECONDS);
        pool.schedule(t5, 10, TimeUnit.MILLISECONDS);
//关闭线程池
        pool.shutdown();
    }

    public static void main(String[] args) {
        DelayThreadPool delayThreadPool = new DelayThreadPool();
        delayThreadPool.test();
    }
}
