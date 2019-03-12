## 1. 目录
1. 线程安全基础知识、synchronized、volatile关键字的使用场景
1. 线程之间通信wait、notify、ThreadLocal、单例、多线程


## 1. volatile关键字与原子性
1. 背景：  
    先说一下线程执行的时候是怎么处理全局的共享变量的。每个线程都有自己的一个内存区域，每次线程执行之前，都会去把用到的全局变量存个副本到自己的内存区域，然后从线程执行开始直到挂掉，始终操作自己内存区域中的副本，最后线程执行完毕之后，再将数据回写到全局共享的变量中。在比如说存取款、全局计数器等要求实时更新的场景会引发严重的问题
1. volatile关键字的作用：
    标记在共享全局变量上，一旦被volatile标记的变量发生了改变，主线程就会通知到各相关子线程，各子线程就会将自己内存区中的副本数据更新一下，然后再进行后续的操作，这样就实现了实时更新的效果
1. 未使用volatile关键字的情况
    ``` java
    public class VolatileUseThread implements Runnable {

        private Boolean stopFlag = true;
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
    ```  
    ![image text](images/thread06.png)
1. 使用了volatile的情况
    ``` java
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
    ```  
    ![image text](images/thread07.png)









ACID，指数据库事务正确执行的四个基本要素的缩写。包含：原子性（Atomicity）、一致性（Consistency）、隔离性（Isolation）、持久性（Durability）
    1. 一致性：
    1. 原子性：指一个操作是不可中断的，要么全部执行成功要么全部执行失败，有着“同生共死”的感觉