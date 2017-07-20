package test;

import static net.mindview.util.Print.print;
import static net.mindview.util.Print.printnb;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class StringTest {
    
    @Test
    public void test1(){
        String a = "123";
        String b = "123"+"2";
        String c = "1232";
        System.out.println(a==b);
        System.out.println(b==c);
    }
    
    @Test
    public void test2(){
        String a = "你";
        byte[] bytes = a.getBytes();
        String format = String.format("%02X", bytes[0]);
        System.out.println(bytes[0] & 0xff);
        System.out.println(format);
    }
    
    @Test
    public void test3(){
        String s = "abcabcabc";
        Pattern compile = Pattern.compile("(?a)");
        Matcher matcher = compile.matcher(s);
        while(matcher.find()){
            String group = matcher.group();
            System.out.println(group);
        }
    }
    
    @Test
    public void test4(){
        String POEM =
                "Twas brillig, and the slithy toves\n" +
                "Did gyre and gimble in the wabe.\n" +
                "All mimsy were the borogoves,\n" +
                "And the mome raths outgrabe.\n\n" +
                "Beware the Jabberwock, my son,\n" +
                "The jaws that bite, the claws that catch.\n" +
                "Beware the Jubjub bird, and shun\n" +
                "The frumious Bandersnatch.";
        
        Matcher m = Pattern.compile("\\W+([a-z]+)").matcher(POEM);
        Set<String> s = new HashSet<String>();
        while (m.find()) {
            s.add(m.group(1));
        }
        System.out.println(s);
    }
    
    @Test
    public void test5(){
        String s = "abcdefg";
        Pattern p = Pattern.compile("abcdefg");
        Matcher matcher = p.matcher(s); 
        System.out.println(matcher.find());
        System.out.println(matcher.lookingAt()); //开头匹配
        System.out.println(matcher.matches()); //完成匹配
    }
    
    @Test
    public void test6(){
        String s = "ab2134232ewfa2323223ewwe";
        Pattern p = Pattern.compile("([a-zA-Z])|([0-9])");
        Matcher m = p.matcher(s);
        StringBuffer buf = new StringBuffer();
        
        //将所有匹配到的英文字母，替换成大写
        while(m.find()){
            if(m.group(1)!=null)
                m.appendReplacement(buf,m.group().toUpperCase());
            System.out.println(m.group(1));
        }
        m.appendTail(buf);
        System.out.println(buf);
    }
    
    @Test
    public void test7(){
        File absoluteFile = new File("src/test/StringTest.java").getAbsoluteFile();
        System.out.println(absoluteFile);
    }
    
    @Test
    public void test8(){
        String str = "lis 33 true";
        Scanner scanner = new Scanner(str);
        System.out.println("姓名："+scanner.next());
        System.out.println("年龄："+scanner.nextInt());
        System.out.println("男："+scanner.nextBoolean());
    }
    
    @Test
    public void test9(){
        String str = "lis - 33 - true";
        Scanner scanner = new Scanner(str);
        scanner.useDelimiter("\\s*-\\s*");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        Matcher matcher = scanner.delimiter().compile("\\s*-\\s*").matcher(str);
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }
    
    @Test
    public void test10(){
        String threatData =
                "58.27.82.161@02/10/2005\n" +
                "204.45.234.40@02/11/2005\n" +
                "58.27.82.161@02/11/2005\n" +
                "58.27.82.161@02/12/2005\n" +
                "58.27.82.161@02/12/2005\n" +
                "[Next log section with different data format]";
        Scanner scanner = new Scanner(threatData);
        String pattern = "(\\d+\\.\\d+\\.\\d+\\.\\d+)@(\\d+/\\d+/\\d+)";
        while(scanner.hasNext(pattern)){
            //String next = scanner.next(pattern);
            scanner.next(pattern);
            MatchResult match = scanner.match();
            String ip = match.group(1);
            String date = match.group(2);
            System.out.println(ip+" : "+date);
        }
    }
}

