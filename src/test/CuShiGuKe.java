package test;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *<p> Title: Testt </p>
 *<p> Description: </p>
 * 生产者消费多线程测试。
 * @author Administrator
 * @since 2017年10月16日
 */
public class CuShiGuKe {
    private static LinkedBlockingQueue<String> panzi = new LinkedBlockingQueue<String>();
    
    public static void main(String[] args) throws InterruptedException {
        ExecutorService poll = Executors.newCachedThreadPool();
        
        for(int i=0; i<5; i++){
            poll.execute(new Chushi(panzi));
        }
        for(int i=0; i<5; i++){
            poll.execute(new Guke(panzi));
        }
        Thread.sleep(4000);
        poll.shutdownNow();
    }
}

class Chushi implements Runnable{
    private static int count = 1;
    private final int id = count++;
    private BlockingQueue<String> panzi;
    public Chushi(BlockingQueue<String> panzi){
        this.panzi = panzi;
    }
    
    @Override
    public void run() {
        try {
           while(!Thread.interrupted()){
               Thread.sleep(1000);
               String makeCai = makeCai();
               panzi.put(makeCai);
               System.out.println(this+"出菜\t\t"+makeCai);
           }
           System.out.println("厨师"+id+"已罢工");
        }
        catch (InterruptedException e) {
            System.out.println("厨师"+id+"已累死");
        }
    }
    
    
    public String makeCai(){
        String[] cais = {"宫保鸡丁","农家一碗香","胡萝卜炒肉","青椒炒肉","糖醋排骨","香干炒肉","铁板牛肉","空心菜"};
        Random random = new Random();
        return cais[random.nextInt(cais.length)]+random.nextInt(1000);
    }
    
    @Override
    public String toString() {
        return Thread.currentThread()+" #厨师"+id;
    }
}

class Guke implements Runnable{
    private static int count = 1;
    private final int id = count++;
    private BlockingQueue<String> panzi;
    public Guke(BlockingQueue<String> panzi){
        this.panzi = panzi;
    }
    
    @Override
    public void run() {
        try {
            while(!Thread.interrupted()){
                String cai = panzi.take();
                Thread.sleep(100);
                System.out.println(this+"消费了：\t"+cai);
            }
            System.out.println("顾客"+id+"已结账");
        }
        catch (Exception e) {
            System.out.println("顾客"+id+"已撑死");
        }
    }
    
    @Override
    public String toString() {
        return Thread.currentThread()+" #顾客"+id;
    }
}