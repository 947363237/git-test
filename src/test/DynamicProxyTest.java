package test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

class DynamicProxy  implements InvocationHandler{
    
    private Object objcet;
    
    DynamicProxy(Object objcet){
        this.objcet = objcet;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long begin = System.currentTimeMillis();
        Object invoke = method.invoke(objcet, args);
        long end = System.currentTimeMillis();
        System.out.printf("耗时：%d", end-begin);
        return invoke;
    }
    
}

interface Print{
    String print(String str);
}
class Show2 implements Print {

    @Override
    public String print(String str) {
        System.out.println(str);
        return str;
    }
    
}

public class DynamicProxyTest{
    public static void main(String[] args) {
        Print newProxyInstance = (Print)Proxy.newProxyInstance(Print.class.getClassLoader(), 
            new Class[]{Print.class}, 
            new DynamicProxy(new Show2()));
        newProxyInstance.print("Hello World!");
        
        SecurityManager securityManager = System.getSecurityManager();
        System.out.println(securityManager);
    }
}
