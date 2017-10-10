package test;

import java.awt.Container;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;


public class Test1 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<String,String>();
        for (int i = 0; i < 50; i++) {
            map.put(i+"", i+"");
        }
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

