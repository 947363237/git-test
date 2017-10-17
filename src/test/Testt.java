package test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;


public class Testt {
    public static void main(String[] args) throws InterruptedException {
        PriorityBlockingQueue<Num> q = new PriorityBlockingQueue<Num>();
        ExecutorService poll = Executors.newCachedThreadPool();
        
        poll.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    while(!Thread.interrupted()){
                        System.out.println(q.take());
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        Random random = new Random();
        for(int i=0; i<10; i++){
            q.offer(new Num(random.nextInt(100)));
        }
    }
}

class Num implements Comparable<Num>{
    int n;
    
    Num(int n){
        this.n = n;
    }
    
    @Override
    public int compareTo(Num o) {
        if(o.n==n)
            return 0;
        if(o.n>n)
            return 1;
        return -1;
    }
    
    @Override
    public String toString() {
        return n+"";
    }
}