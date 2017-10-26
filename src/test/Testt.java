package test;

import io.FilePath;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.io.StringReader;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

import concurrency.ReaderWriterList;


public class Testt {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = Executors.newCachedThreadPool();
        
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("tt", "rw");
                    randomAccessFile.write("1".getBytes());
                    randomAccessFile.write("2".getBytes());
                    randomAccessFile.write("3".getBytes());
                    randomAccessFile.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("tt", "rw");
                    randomAccessFile.seek(3);
                    randomAccessFile.write("4".getBytes());
                    randomAccessFile.write("5".getBytes());
                    randomAccessFile.write("6".getBytes());
                    randomAccessFile.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        pool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    RandomAccessFile randomAccessFile = new RandomAccessFile("tt", "rw");
                    randomAccessFile.seek(6);
                    randomAccessFile.write("7".getBytes());
                    randomAccessFile.write("8".getBytes());
                    randomAccessFile.write("9".getBytes());
                    randomAccessFile.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}

  