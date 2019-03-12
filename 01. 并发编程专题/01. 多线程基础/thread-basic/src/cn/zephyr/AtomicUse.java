package cn.zephyr;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/12 15:43
 * @Description:
 */
public class AtomicUse {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    // AtomicInteger类能保证每次+2、+3、+5的单次操作的原子性，不能保证整体multiAdd方法（+10）的原子性
    public/* synchronized */void multiAdd() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        atomicInteger.addAndGet(2);
        atomicInteger.addAndGet(3);
        atomicInteger.addAndGet(5);
        System.err.print(atomicInteger+" ");
    }

    public static void main(String[] args) {
        AtomicUse atomicUse = new AtomicUse();
        // 创建10条线程并运行
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                // +10 方法执行10次
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        atomicUse.multiAdd();
                    }
                }
            }).start();
        }
    }
}
