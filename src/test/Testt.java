package test;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import concurrency.NotifyVsNotifyAll;
import concurrency.SleepingTask;

public class Testt {
    private static int a = 0;
    public static ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
    public static synchronized  int zizeng(){
        return a++;
    }
    public static void main(String[] args) throws InterruptedException {
        Object object = new Object();
        int i = 0;
        for (int j=i; i < 1000; i++) {
            newCachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    zizeng();
                }
            });
        }
        System.out.println(i);
//        Thread.sleep(1000);
        newCachedThreadPool.shutdown();
        System.out.println(a);
        while(true){
            if(newCachedThreadPool.isTerminated()){
                System.out.println(a);
                break;
            }
        }
    }


}
