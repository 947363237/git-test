package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class Test5 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4);
        
        List<Integer> subList = list.subList(0, 1);
        System.out.println(subList);
        
        System.out.println(list.containsAll(subList));
        
        int a = 123;
        int b = 12;
        System.out.println();
    }
    
}

