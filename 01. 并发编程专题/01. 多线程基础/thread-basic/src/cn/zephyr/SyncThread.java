package cn.zephyr;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/12 16:47
 * @Description:
 */
public class SyncThread implements Runnable {
    public int count=5;
    @Override
    public synchronized void run() {
        count--;
        System.err.println(Thread.currentThread().getName()+":count="+count);
    }

    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        for (int i = 0; i < 5; i++) {
            new Thread(syncThread,"thread-"+i).start();
        }
    }
}
