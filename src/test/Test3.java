package test;

import java.util.Date;

class OutClass{
    static class  OutClass2{
        static  class  InnerClass{
            public String str;
            InnerClass(String str){
                this.str = str;
            }
            public void show(){
                System.out.println(str);
            }
        }
    }
}

public class Test3 extends OutClass.OutClass2.InnerClass{
    Test3(OutClass.OutClass2 out) {
        super("");
    }

    public static void main(String[] args) {
    }
}

 