package cn.zephyr;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/11 17:38
 * @Description:
 */
public class ThreadDaemon01 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.err.println("这里是子线程--"+i);
            }
        });
        thread.setDaemon(true);
        thread.start();
        for (int i = 10; i < 20; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println("这里是主线程--"+i);
        }
        System.err.println("主线程挂掉！");
    }
}
