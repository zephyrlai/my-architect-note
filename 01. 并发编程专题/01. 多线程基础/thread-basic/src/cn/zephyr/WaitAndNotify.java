package cn.zephyr;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: zephyrLai
 * @Date: 2019/3/12 17:48
 * @Description:
 */
public class WaitAndNotify {
    static List<String> myList = new ArrayList<>();

    public static void main(String[] args) {
        Object lockObj = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObj){
                    for (int i = 0; i < 10; i++) {
                        myList.add("");
                        System.err.println(Thread.currentThread().getName() + "添加了一个元素");
                        if(myList.size()==5){
                            lockObj.notify();
                        }
                    }
                }

            }
        },"thread01").start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockObj){
                    if(myList.size() != 5) {
                        try {
                            System.err.println("进入thread02");
                            lockObj.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.err.println(Thread.currentThread().getName()+"收到通知，即将终止");
                        throw new RuntimeException("线程02终止");
                    }
                }
            }
        },"thread02").start();
    }
}
