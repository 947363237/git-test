package test;

import java.util.Date;


class show{
    show(String s){
        System.out.println(s);
    }
}

class Parent{
    Parent(){
        System.out.println("10");
    }
    
    private show s = new show("7");
    
    {
        System.out.println("8");
    }
    
    
    private static show s2 = new show("1");
    
    static{
       show ssw = new show("2");
    }
    
    private show sa = new show("9");
}

class Chiled extends Parent{
    Chiled(){
        System.out.println("14");
    }
    
    private show s = new show("11");
    
    {
        System.out.println("12");
    }
    
    private static show s2 = new show("3");
    
    static{
        show ssw = new show("4");
     }
    
    private show sa = new show("13");
}

public class Test4 extends Chiled{
    Test4(){
        System.out.println("18");
    }
    
    private show s = new show("15");
    
    {
        System.out.println("16");
    }
    
    private static show s2 = new show("5");
    
    static{
        show ssw = new show("6");
     }
    
    private show sa = new show("17");
    
    public static void main(String[] args) {
           new Test4();
    }
}

 