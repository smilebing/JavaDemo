package ExecutorsDemo;

/**
 * Created by zhuhe on 2018/4/19.
 */
public class MyThread extends Thread {
    @Override

    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行。。。");
    }
}
