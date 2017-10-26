//: net/mindview/util/BinaryFile.java
// Utility for reading files in binary form.
package net.mindview.util;
import io.FilePath;

import java.io.*;

public class BinaryFile {
  public static byte[] read(File bFile) throws IOException{
    BufferedInputStream bf = new BufferedInputStream(
      new FileInputStream(bFile));
    try {
      byte[] data = new byte[bf.available()];
      bf.read(data);
      return data;
    } finally {
      bf.close();
    }
  }
  public static byte[]
  read(String bFile) throws IOException {
    return read(new File(bFile).getAbsoluteFile());
  }
  
  public static void main(String[] args) throws IOException {
      byte[] read = BinaryFile.read(FilePath.readPath);
      PrintStream printStream = new PrintStream(System.out);
      printStream.write(read, 0, read.length);
  }
} ///:~
