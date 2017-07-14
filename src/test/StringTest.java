package test;

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
}

