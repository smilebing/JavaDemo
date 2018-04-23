import ExecutorsDemo.ExecutorsTest;

public class Main {

    public static void main(String[] args) {
        ExecutorsTest executorsTest=new ExecutorsTest();
        executorsTest.run();
        try {
            Thread.sleep(1000*5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorsTest.destroy();
    }
}
