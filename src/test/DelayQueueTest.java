package test;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


public class DelayQueueTest {
    public static void main(String[] args) throws InterruptedException {
        DelayQueue<Delayed> que = new DelayQueue<Delayed>();
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                while(!Thread.interrupted())
                    try {
                        //que.take会等到队列头部的元素到期后才取出来，否则会一直处于阻塞状态
                        System.out.println(que.take()); 
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        }).start();
        
        Thread.sleep(2000);
        ArrayList<DaFan> arrayList = new ArrayList<DaFan>();
        
        Random random = new Random();
        for(int i=0; i<10; i++){
            DaFan daFan = new DaFan(random.nextInt(20000));
            arrayList.add(daFan);
            que.offer(daFan);
        }
        System.out.println(arrayList);
    }
}

//必须实现 Delayed，因为DelayQueue的泛型是 DelayQueue<E extends Delayed>
class DaFan implements Delayed{ 
    private long delay; //毫秒
    private long triggerTime; //纳秒

    public long getDelay() {
        return delay;
    }
    
    public DaFan(long haomiao){
        this.delay = haomiao;
        this.triggerTime = System.nanoTime() 
                +TimeUnit.NANOSECONDS.convert(haomiao, TimeUnit.MILLISECONDS);
    }
    
    @Override
    public int compareTo(Delayed o) {
        DaFan d = (DaFan)o;
        if(o==this)
            return 0;
        return delay<d.getDelay() ? -1:1;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        //将剩下的时间从纳秒转换成unit类型的时间单元
        return unit.convert(triggerTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
    
    @Override
    public String toString() {
        return delay+"";
    }
}