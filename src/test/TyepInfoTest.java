package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.Set;

import org.junit.Test;

import typeinfo.pets.Cat;
import typeinfo.pets.Pet;

public class TyepInfoTest {
    
    @Test
    public void test1(){
        Class<A> clazz = A.class;
        int[] a = {1};
        String canonicalName = a.getClass().getSimpleName();
        System.out.println(canonicalName);
        clazz.getInterfaces();
        Class<? super A> superclass = clazz.getSuperclass();
    }
    
    @Test
    public void test2(){
        String s = int.class.getCanonicalName();
        String canonicalName = Integer.TYPE.getCanonicalName();
        System.out.println(canonicalName);
        System.out.println(s);
    }
    
    @Test
    public void test3(){
       A a = new A();
       B b = new B();
       System.out.println(b instanceof A);
    }
    
    @Test
    public void test4() throws Exception{
       List randomDongWu = RandomDongWu(2);
       Class<?>[] allTypes = {Mao.class,Gou.class,
                              Zhu.class,Ji.class,Ya.class,E.class};
       Map<Class<?>, Integer> hashMap = new HashMap<Class<?>, Integer>();
       for(Class clazz:allTypes){
           hashMap.put(clazz, 0);
       }
       
       
       for(Object o:randomDongWu){
           for(Entry<Class<?>, Integer> entry:hashMap.entrySet()){
               if(entry.getKey().isInstance(o)){
                   hashMap.put(entry.getKey(), entry.getValue()+1);
               }
           }
       }
       System.out.println(hashMap);
    }
    
    public List RandomDongWu(int size) throws Exception{
        Random random = new Random();
        
        Class<?>[] allTypes = {Mao.class,Gou.class,
                                    Zhu.class,Ji.class,Ya.class,E.class};
        
        Class<? extends DongWu> z= Zhu.class;
        
       List arrayList = new ArrayList<Object>();
       for(int i=0; i<size; i++){
           arrayList.add(allTypes[random.nextInt(allTypes.length)].newInstance());
           
       }
       return arrayList;
    }
    
    @Test
    public void test5(){
        LuSeGou mao = new LuSeGou();
        DongWu dongWu = new DongWu();
        boolean instance = LuSeGou.class.isInstance(dongWu);
        System.out.println(instance);
        System.out.println(DongWu.class.isAssignableFrom(Mao.class));
    }
}
class A{}
class B extends A{}

class DongWu{
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
class Mao extends DongWu{}
class Gou extends DongWu{}
class Zhu extends DongWu{}
class Ji extends DongWu{}
class Ya extends DongWu{}
class E extends DongWu{}
class LuSeGou extends Gou{}