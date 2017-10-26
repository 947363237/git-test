package io;
//: io/MemoryInput.java
import java.io.*;

public class MemoryInput {
  public static void main(String[] args)
  throws IOException {
    StringReader in = new StringReader(
      BufferedInputFile.read(FilePath.readPath));
    int c;
    while((c = in.read()) != -1){
      System.out.print((char)c);
    }
  }
} /* (Execute to see output) *///:~
