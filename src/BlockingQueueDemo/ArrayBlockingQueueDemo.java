package BlockingQueueDemo;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhuhe on 2018/5/12.
 */
public class ArrayBlockingQueueDemo {
    //默认非公平阻塞队列
//    ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
    //公平阻塞队列
//    ArrayBlockingQueue queue1 = new ArrayBlockingQueue(2,true);
    private final static ArrayBlockingQueue<Apple> queue = new ArrayBlockingQueue<>(5, false);

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }
}

class Apple {
    private int index;

    public Apple() {
    }

    public Apple(int index) {
        this.index = index;
    }

    public int getIndex(){
        return index;
    }
}

/**
 * 生产者线程
 */
class Producer implements Runnable {
    private final ArrayBlockingQueue<Apple> mAbq;
    private static int appleIndex=1;
    Producer(ArrayBlockingQueue<Apple> arrayBlockingQueue) {
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            Produce();
        }
    }

    private void Produce() {
        try {
            Apple apple = new Apple(appleIndex);
            //队列已满会阻塞
            mAbq.put(apple);
            System.out.println("生产:apple-" + appleIndex);
            appleIndex++;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
 * 消费者线程
 */
class Consumer implements Runnable {

    private ArrayBlockingQueue<Apple> mAbq;

    Consumer(ArrayBlockingQueue<Apple> arrayBlockingQueue) {
        this.mAbq = arrayBlockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                comsume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void comsume() throws InterruptedException {
        Apple apple = mAbq.take();
        System.out.println("消费Apple-" + apple.getIndex());
    }
}
