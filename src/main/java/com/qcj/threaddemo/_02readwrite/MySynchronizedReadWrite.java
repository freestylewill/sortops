package com.qcj.threaddemo._02readwrite;

/**
 *
 * 描述: 一个线程又要读又要写，用synchronize来实现的话，读写操作都只能锁住后一个线程一个线程地进行
 */
public class MySynchronizedReadWrite {

    public static void main(String[] args) {
        final MySynchronizedReadWrite test = new MySynchronizedReadWrite();

        new Thread() {
            public void run() {
                test.operate(Thread.currentThread());
            };
        }.start();

        new Thread() {
            public void run() {
                test.operate(Thread.currentThread());
            };
        }.start();

    }

    public synchronized void operate(Thread thread) {
        long start = System.currentTimeMillis();
        int i = 0;
        while (System.currentTimeMillis() - start <= 1) {
            i++;
            if (i % 4 == 0) {
                System.out.println(thread.getName() + "正在进行写操作");
            } else {
                System.out.println(thread.getName() + "正在进行读操作");
            }
        }
        System.out.println(thread.getName() + "读写操作完毕");
    }

}
