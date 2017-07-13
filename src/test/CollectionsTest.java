package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class CollectionsTest {

    @Test
    public void checkedCollection(){
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        
        
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList.add(12);
        arrayList.add(22);
        arrayList.add(32);
        arrayList.add(42);
        
        ListIterator<Integer> listIterator = arrayList.listIterator(arrayList.size()-1);
        while(listIterator.hasPrevious()){
            arrayList2.add(listIterator.previous());
        }
        
        System.out.println(arrayList2);
    }
}
