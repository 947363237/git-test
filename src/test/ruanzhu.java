package test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ruanzhu {
    
    
    public static void main(String[] args) throws IOException {
        scrz();
    }

    public static void scrz() throws IOException{
        File file = new File("C:/rz");
        if(!file.isDirectory())
            return;
        
        BufferedWriter wt = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("C:/output.txt")));
        File[] listFiles = file.listFiles();
        for (File fil : listFiles) {
            System.out.println(fil.getPath());
            if(fil.isFile()){
                rd(fil,wt);
            }
        }
        wt.close();
    }

    public static void rd(File file, BufferedWriter wt) throws FileNotFoundException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        String line = "";
        while((line=bufferedReader.readLine())!= null){
            if(line==null || "".equals(line.trim()))
                continue;
            wt.write(line);
            wt.newLine();
            wt.flush();
        }
        bufferedReader.close();
    }
}
