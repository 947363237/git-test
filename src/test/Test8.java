package test;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Rodent;

class MyHolder3<T> {
    private T t1;
    private T t2;
    private T t3;

    public MyHolder3(T t1,T t2,T t3) {
        this.t1 = t1;
        this.t2 = t2;
        this.t3 = t3;
    }
    
}

class MyTwoTuple<A,B>{
    public final A a;
    public final B b;
    MyTwoTuple(A a,B b){
        this.a = a;
        this.b = b;
    }
}

class ThreeTuple<A,B,C> extends MyTwoTuple<A,B>{
    public final C c;
    
    ThreeTuple(A a, B b,C c) {
        super(a, b);
        this.c = c;
    }
}

public class Test8 {
    public static void main(String[] args) {
        ThreeTuple<String,String,String> print = print("name", "age","dss");
        System.out.println(print.a);
        System.out.println(print.b);
        System.out.println(print.c);
    }
    
    public static ThreeTuple<String,String,String> print(String name,String age,String sex){
        return new ThreeTuple<>(name,age,sex);
    }
}
