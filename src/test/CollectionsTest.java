package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;

import org.junit.Test;

public class CollectionsTest {

    @Test
    public void checkedCollection(){
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(12,332,32,4,15));
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>(linkedList.size(), Collections.reverseOrder());
        priorityQueue.addAll(linkedList);
        
        while(priorityQueue.peek()!=null){
            System.out.print(priorityQueue.poll()+" ");
        }
        
        Integer[] arr = new Integer[]{1,22,223,4,5,6};
        Arrays.sort(arr,Collections.reverseOrder());
        System.out.println(Arrays.toString(arr));
    }
}
