package ExecutorsDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhuhe on 2018/4/19.
 */
public class SingleSizeThreadPool {
    public void test() {
        //单一大小
        ExecutorService pool = Executors.newSingleThreadExecutor();
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
        pool.shutdown();
    }

    public static void main(String [] args){
        SingleSizeThreadPool singleSizeThreadPool=new SingleSizeThreadPool();
        singleSizeThreadPool.test();
    }
}
