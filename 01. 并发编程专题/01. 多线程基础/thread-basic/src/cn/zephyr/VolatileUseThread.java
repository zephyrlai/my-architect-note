package cn.zephyr;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/12 16:04
 * @Description: Volatile关键字使用
 */
public class VolatileUseThread implements Runnable {

    private /*volatile*/ Boolean stopFlag = true;
    @Override
    public void run() {
        while(stopFlag){

        }
        System.err.println("子线程停止");
    }

    public static void main(String[] args) throws InterruptedException {
        VolatileUseThread myThread = new VolatileUseThread();
        new Thread(myThread).start();
        Thread.sleep(100);
        myThread.stopFlag=false;
        System.err.println("停止标志位已置位false");
        System.err.println("主线程停止");
    }
}
