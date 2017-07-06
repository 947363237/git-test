package test;

import java.util.Date;

import test.A.B.C.D;

public class Test3 {

}

class AA{
    void show(){
        System.out.println("AA");
    }
}

class A extends AA{
    public class B{
        public class C{
            public class D{
                void show(){
                    A.super.show();
                }
                
                public B getB(){
                    return B.this;
                }
            }
            
            void show(){
                System.out.println("C");
            }
        }
        
        void show(){
            System.out.println("B");
        }
    }
    
    void show(){
        System.out.println("A");
    }
    
    public static void main(String[] args) {
        System.out.println(new Date(System.nanoTime()));
    }
}
 