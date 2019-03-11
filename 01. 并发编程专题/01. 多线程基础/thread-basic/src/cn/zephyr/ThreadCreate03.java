package cn.zephyr;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/11 17:25
 * @Description: 匿名内部类形式创建线程
 */
public class ThreadCreate03 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.err.println("这里是子线程--"+i);
                }
            }
        });
        thread.start();
        for (int i = 10; i < 20; i++) {
            System.err.println("这里是主线程--"+i);
        }
    }
}
