package test;

import io.FilePath;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class Testt {
    public static void main(String[] args) throws Exception {
        ByteBuffer allocate = ByteBuffer.allocate(1024);
        ByteBuffer wrap = allocate.wrap("abc".getBytes());
        FileChannel channel = new FileOutputStream(FilePath.outPath).getChannel();
        System.out.println(allocate.limit());
    }
}
