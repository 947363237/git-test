package test;

import java.util.Random;

public class Testt {
    private static ThreadLocal<Integer> myThreadLocal = new ThreadLocal<Integer>(){
        protected synchronized Integer initialValue() {
            return new Random().nextInt(100);
        };
    };
    
//    protected int a;
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                
                @Override
                public void run() {
                    Integer integer = myThreadLocal.get();
                    System.out.println(integer);
                }
            }).start();
        }
    }
}

class PairManager {
    int a = 3;
}

  // Synchronize the entire method:
class PairManager1 extends PairManager {
    public synchronized void increment() {
        a++;
        System.out.println(a);
    }
}
  
