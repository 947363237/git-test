package test;

import io.FilePath;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;


public class ExternalizableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        PersonObj person = new PersonObj();
        person.name = "lis";
        person.age = 12;
        person.sex = '男';
        BBB bbb = new BBB();
        bbb.name = "我是BBB";
        person.ps =bbb ;
        
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteArrayOutputStream);
        out.writeObject(person);
        out.close();
        
        ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Object readObject = in.readObject();
        System.out.println(readObject);
    }
}

class PersonObj implements Serializable{
    transient String name; //不会被序列化
    int age;
    char sex;
    BBB ps; //BBB实现了Externalizable，也不会被序列化
    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", sex=" + sex + ", ps=" + ps + "]";
    }
}


class BBB implements Externalizable{ //尝试将Externalizable改成Serializable观察结果
    String name;
    public BBB(){}
    
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        
    }

    @Override
    public String toString() {
        return name;
    }
}