package ExecutorsDemo;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhuhe on 2018/4/17.
 */
public class ExecutorsTest {

    private ExecutorService service;
    public Boolean needShutDown;

    public ExecutorsTest() {
        needShutDown = false;
    }

    public void run() {
        service = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            @Override
            public void run() {
                while (!needShutDown) {
                    System.out.println(new Date());
                    try {
                        Thread.sleep(1000 * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    public void destroy() {
        needShutDown=true;
        service.shutdown();
    }
}
