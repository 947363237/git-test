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

public class CollectionsTest{

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
    
    @Test
    public void test2(){
        class Random implements Iterable<Integer>{
            private Integer count;
            private java.util.Random random = new java.util.Random();
            
            Random(Integer count){
                this.count = count;
            }
            @Override
            public Iterator<Integer> iterator() {
                return new Iterator<Integer>(){
                    private int i = 0;
                    @Override
                    public boolean hasNext() {
                        return i++ < count;
                    }

                    @Override
                    public Integer next() {
                        return random.nextInt(10000);
                    }
                };
            }
            
        }
        
        Random random = new Random(3);
        for (Integer it : random) {
            System.out.println(it);
        }
    }
    
    @Test
    public void test3(){
        class UserList<T> extends ArrayList<T>{
            public Iterable<T> reverseEach(){
                return new Iterable<T>() {

                    @Override
                    public Iterator<T> iterator() {
                        return new Iterator<T>() {
                            private int count = size()-1;
                            
                            @Override
                            public boolean hasNext() {
                                return count > -1;
                            }

                            @Override
                            public T next() {
                                return get(count--);
                            }
                        };
                    }
                };
            } 
        }
        
        UserList<String> userList = new UserList<String>();
        userList.add("1");
        userList.add("2");
        userList.add("3");
        
        for (String s : userList.reverseEach()) {
            System.out.println(s);
        }
    }
}
