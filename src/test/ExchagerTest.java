package test;

import static java.util.concurrent.TimeUnit.MILLISECONDS;
import static java.util.concurrent.TimeUnit.NANOSECONDS;
import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.SheetCollate;

import concurrency.Fat;
import concurrency.Pool;


public class ExchagerTest {
    public static void main(String[] args) throws InterruptedException{
        Exchanger<List<Fat>> xc = new Exchanger<List<Fat>>();
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        
        newCachedThreadPool.execute(new SC(new ArrayList<Fat>(), xc));
        newCachedThreadPool.execute(new XF(new ArrayList<Fat>(), xc));
    }
}

//生产者
class SC implements Runnable{
    Exchanger<List<Fat>> xc;
    private List<Fat> list;
    public SC(List<Fat> list,Exchanger<List<Fat>> xc){
        this.list = list;
        this.xc = xc;
    }
    
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            list.add(new Fat());
        }
        try {
            xc.exchange(list); //这里会阻塞，知道另一个跟其进行交换
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

//消费者
class XF implements Runnable{
    Exchanger<List<Fat>> xc;
    private List<Fat> list;
    public XF(List<Fat> list,Exchanger<List<Fat>> xc){
        this.list = list;
        this.xc = xc;
    }
    
    @Override
    public void run() {
        try {
            list = xc.exchange(list); //这里会阻塞，知道另一个跟其进行交换
            System.out.println(list);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

