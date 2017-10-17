package concurrency;
//: concurrency/ToastOMatic.java
// A toaster that uses queues.
import java.util.concurrent.*;
import java.util.*;
import static net.mindview.util.Print.*;

class Toast {
  public enum Status { DRY, BUTTERED, JAMMED }
  private Status status = Status.DRY;
  private final int id;
  public Toast(int idn) { id = idn; }
  public void butter() { status = Status.BUTTERED; }
  public void jam() { status = Status.JAMMED; }
  public Status getStatus() { return status; }
  public int getId() { return id; }
  public String toString() {
    return "Toast " + id + ": " + status;
  }
}

class ToastQueue extends LinkedBlockingQueue<Toast> {}

//烤面包
class Toaster implements Runnable {
  private ToastQueue toastQueue;
  private int count = 0;
  private Random rand = new Random(47);
  public Toaster(ToastQueue tq) { toastQueue = tq; }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        TimeUnit.MILLISECONDS.sleep( 
            
          100 + rand.nextInt(500));
        // Make toast
        Toast t = new Toast(count++); //生产面包
        print(t);
        // Insert into queue
        toastQueue.put(t); //将烤好的面包放进去
      }
    } catch(InterruptedException e) {
      print("Toaster interrupted");
    }
    print("Toaster off");
  }
}

// Apply butter to toast: 
//涂奶油
class Butterer implements Runnable {
  private ToastQueue dryQueue, butteredQueue;
  public Butterer(ToastQueue dry, ToastQueue buttered) {
    dryQueue = dry;
    butteredQueue = buttered;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = dryQueue.take(); //查看有没有烤好的面包，如果没有将一直阻塞
        t.butter(); //给面包涂奶油
        print(t);
        butteredQueue.put(t); //将涂过奶油的面包存进去
      }
    } catch(InterruptedException e) {
      print("Butterer interrupted");
    }
    print("Butterer off");
  }
}

// Apply jam to buttered toast: 
//涂果酱
class Jammer implements Runnable {
  private ToastQueue butteredQueue, finishedQueue;
  public Jammer(ToastQueue buttered, ToastQueue finished) {
    butteredQueue = buttered;
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = butteredQueue.take();
        t.jam();
        print(t);
        finishedQueue.put(t);
      }
    } catch(InterruptedException e) {
      print("Jammer interrupted");
    }
    print("Jammer off");
  }
}

// Consume the toast:
class Eater implements Runnable {
  private ToastQueue finishedQueue;
  private int counter = 0;
  public Eater(ToastQueue finished) {
    finishedQueue = finished;
  }
  public void run() {
    try {
      while(!Thread.interrupted()) {
        // Blocks until next piece of toast is available:
        Toast t = finishedQueue.take(); //吃掉面包
        // Verify that the toast is coming in order,
        // and that all pieces are getting jammed:
        if(t.getId() != counter++ ||
           t.getStatus() != Toast.Status.JAMMED) {
          print(">>>> Error: " + t);
          System.exit(1);
        } else
          print("Chomp! " + t);
      }
    } catch(InterruptedException e) {
      print("Eater interrupted");
    }
    print("Eater off");
  }
}

public class ToastOMatic {
  public static void main(String[] args) throws Exception {
    ToastQueue dryQueue = new ToastQueue(), //存放烤好的面包
               butteredQueue = new ToastQueue(), //存放涂过奶油的面包
               finishedQueue = new ToastQueue(); //存放涂过果酱的面包
    ExecutorService exec = Executors.newCachedThreadPool();
    exec.execute(new Toaster(dryQueue));
    exec.execute(new Butterer(dryQueue, butteredQueue));
    exec.execute(new Jammer(butteredQueue, finishedQueue));
    exec.execute(new Eater(finishedQueue));
    TimeUnit.SECONDS.sleep(5);
    exec.shutdownNow();
  }
} /* (Execute to see output) *///:~
