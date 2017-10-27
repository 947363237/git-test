//: net/mindview/util/OSExecute.java
// Run an operating system command
// and send the output to the console.
package net.mindview.util;
import java.io.*;

/**
 *<p> Title: OSExecute 这个程序有所改动，原版的存在线程阻塞问题，具体请参考： </p>
 * http://zzldn.iteye.com/blog/1007831
 * http://blog.csdn.net/dancen/article/details/7969328
 * 
 * 
 * 这里大致的说以原理，以win7操作系统为例：
 * Java中 Runtime.getInstance().exec (String cmd) 或者 new ProcessBuilder(String cmd).start() 都可以产生子进程对象Process
 * process执行命令会开启一个子进程，子进程的执行结果会输出到标准输入流 inputStream, errorStream，由于有些本机平台仅针对标准输入和输出流提供有限的缓冲区大小
 * 当缓冲区被填满时，读写子进程的输出流或输入流迅速出现失败，则可能导致子进程阻塞，甚至产生死锁。
 * 出现阻塞或死锁的原因就是，当通过Process执行的系统命令会在子进程里面进行，通过获取其输入输出流可以在主线程(main方法所在线程)里面读取输出内容，
 * 如果结果被输出到errorStream，但是却在inputStream里面进行读取，此时是读取不到的。当errorStream的占满了缓冲区时，如果没有即使的释放就会导致线程阻塞甚至死锁，
 * 所以解决方案是读取errorStream的内容将其释放。
 * 注意：在多线程中 interrupt不能中断正在试图获取synchronized锁或者试图执行I/O操作的线程。
 *<p> Description: </p>
 *
 * @author Administrator
 * @since 2017年10月27日
 */ 
public class OSExecute {
  public static void command(String command) {
    boolean err = false;
    try {
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        //将错误输出流合并到getInputStream，防止线程阻塞，出现死锁的情况，这是java SE5之后的处理方式，如果是早起版本，可以采用线程并发处理缓冲去的方案
        processBuilder.redirectErrorStream(true); 
      Process process = processBuilder.start();
      BufferedReader results = new BufferedReader(
        new InputStreamReader(process.getInputStream(),"GBK"));
      String s;
      while((s = results.readLine())!= null)
        System.out.println(s);
      
      int waitFor = process.waitFor();
      System.out.println(waitFor);
    } catch(Exception e) {
      // Compensate for Windows 2000, which throws an
      // exception for the default command line:
      if(!command.startsWith("CMD /C"))
        command("CMD /C " + command);
      else
        throw new RuntimeException(e);
    }
    if(err)
      throw new OSExecuteException("Errors executing " +
        command);
  }
  
  public static void main(String[] args) {
      command("java");
  }
} ///:~
