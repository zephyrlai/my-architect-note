package cn.zephyr;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/11 17:22
 * @Description: 实现Runnable接口创建线程
 */
class MyRunnableThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println("这里是子线程--"+i);
        }
    }
}

public class ThreadCreate02 {
    public static void main(String[] args) {
        new Thread(new MyRunnableThread()).start();
        for (int i = 10; i < 20; i++) {
            System.err.println("这里是主线程-"+i);
        }
    }
}
