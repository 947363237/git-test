package io;
//: io/GetChannel.java
// Getting channels from streams
import java.nio.*;
import java.nio.channels.*;
import java.io.*;

public class GetChannel {
  private static final int BSIZE = 1024;
  public static void main(String[] args) throws Exception {
    // Write a file:
    FileChannel fc =
      new FileOutputStream(FilePath.outPath).getChannel();
    fc.write(ByteBuffer.wrap("Some text ".getBytes()));
    fc.close();
    
    // Add to the end of the file:
    fc =
      new RandomAccessFile(FilePath.outPath, "rw").getChannel();
    fc.position(fc.size()); // Move to the end
    fc.write(ByteBuffer.wrap("Some more".getBytes()));
    fc.close();
    
    // Read the file:
    fc = new FileInputStream(FilePath.outPath).getChannel();
    ByteBuffer buff = ByteBuffer.allocate(BSIZE);
    fc.read(buff);
    buff.flip(); //读取写入到buff里面的数据之前都需要先调用flip为读取做准备
    while(buff.hasRemaining())
      System.out.print((char)buff.get());
  }
} /* Output:
Some text Some more
*///:~
