package cn.zephyr;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/11 17:16
 * @Description: 继承Thread类形式创建线程
 */
class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println("这里是子线程--"+i);
        }
    }
}

public class ThreadCreate01 {
    public static void main(String[] args) {
        new MyThread().start();
        for (int i = 10; i < 20; i++) {
            System.err.println("这里是主线程-"+i);
        }
    }
}
