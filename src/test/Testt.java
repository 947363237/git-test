package test;

import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

import javax.swing.RowFilter.Entry;

import concurrency.DaemonFromFactory;

public class Testt {
    public static void main(String[] args) throws Exception {
        Thread thread = new Thread(new Person("lis"));
        new Thread(new Runnable() {
            
            @Override
            public void run() {
                try {
                    thread.join();
                    System.out.println("me");
                }
                catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
        thread.start();
    }
}


class Person implements Runnable{
    private String name;
    public Person(String name){
        this.name = name;
    }
    @Override
    public void run() {
        try {
            for(int i=0; i<13; i++){
                Thread.sleep(1000);
                System.out.println(name);
            }
        }
        catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}