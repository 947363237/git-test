package io;
//: io/GZIPcompress.java
// {Args: GZIPcompress.java}
import java.util.zip.*;
import java.io.*;
import java.nio.charset.Charset;

public class GZIPcompress {
  public static void main(String[] args)
  throws IOException {
    if(args.length == 0) {
      System.out.println(
        "Usage: \nGZIPcompress file\n" +
        "\tUses GZIP compression to compress " +
        "the file to test.gz");
      System.exit(1);
    }
    BufferedReader in = new BufferedReader(
      new FileReader(args[0]));
    
    ////原版。这样写，中文时会出现中文乱码
//    BufferedOutputStream out = new BufferedOutputStream(
//      new GZIPOutputStream(
//        new FileOutputStream("test.gz")));
    
    //这样不会出现中文乱码问题
    BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream("test.gz"))));
    
    System.out.println("Writing file");
    
    //原版
//  int c;
//  while((c = in.read()) != null)
    
    String c = "";
    while((c = in.readLine()) != null)
      out.write(c);
    in.close(); 
    out.close();
    System.out.println("Reading file");
    BufferedReader in2 = new BufferedReader(
      new InputStreamReader(new GZIPInputStream(
        new FileInputStream("test.gz")),"utf-8"));
    String s;
    while((s = in2.readLine()) != null)
      System.out.println(s);
  }
} /* (Execute to see output) *///:~
