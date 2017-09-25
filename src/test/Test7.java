package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class Printer implements Iterable<String>{
    
    private final List<String> list = new ArrayList<String>();
    
    public Printer print(Integer... goods){
        for (Integer integer : goods) {
            list.add(integer.toString());
        }
        return this;
    }
    
    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            private List<String> numberZhArr = Arrays.asList("zero","one","two","threen"
                ,"four","five","sex","seven","eight","nine");
            
            @Override
            public String next() {
                return numberZhArr.get(Integer.parseInt(list.get(index++)));
            }
            
            @Override
            public boolean hasNext() {
                return index < list.size();
            }
        };
    }
}

public class Test7 {
    public static void main(String[] args) {
        for (String num : new Printer().print(2,3,4,5,6,7,8,9,0)) {
            System.out.println(num);
        }
    }
}
