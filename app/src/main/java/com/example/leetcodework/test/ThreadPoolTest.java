package com.example.leetcodework.test;

import java.util.Random;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
//        创建3个线程
        MyThreadPool pool = new MyThreadPool(3,0);
        pool.execute(new MyTask("testA"));
        pool.execute(new MyTask("testB"));
        pool.execute(new MyTask("testC"));
        pool.execute(new MyTask("testD"));
        pool.execute(new MyTask("testE"));
        System.out.println(pool);
        Thread.sleep(10000);
        //所有任务执行完成才destory
        pool.destory();
        System.out.println(pool);
        //机器的cpu核心数
        System.out.println(Runtime.getRuntime().availableProcessors());

    }

    /**
     * 任务类
     */
    static class MyTask implements Runnable{
        private String name;
        private Random r = new Random();
        public MyTask(String name){
            this.name = name;
        }

        public String getName(){
            return name;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(r.nextInt(1000)+2000);
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getId()+" sleep InterruptedException:"
                        +Thread.currentThread().isInterrupted());
            }
            System.out.println("任务 " + name + " 完成");
        }
    }

}
