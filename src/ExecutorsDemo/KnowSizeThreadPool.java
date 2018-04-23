package ExecutorsDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhuhe on 2018/4/19.
 */
public class KnowSizeThreadPool {
    public void test() {
        //创建固定大小的线程池
        ExecutorService pool = Executors.newFixedThreadPool(3);

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
        pool.execute(t4);
        pool.execute(t5);
        //关闭线程池
        pool.shutdown();
    }



    public static void main(String[] args) {
        KnowSizeThreadPool knowSizeThreadPool = new KnowSizeThreadPool();
        knowSizeThreadPool.test();
    }
}
