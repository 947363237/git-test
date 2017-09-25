package test;

interface Interface{
    void show();
}

class RealObejct implements Interface{

    @Override
    public void show() {
       System.out.println("my's RealObject"); 
    }
    
}

class RealObejctProxy{
    private RealObejct realObejct;
    
    RealObejctProxy(RealObejct realObejct){
        this.realObejct = realObejct;
    }
    
    public void show(){
        long begin = System.currentTimeMillis();
        realObejct.show();
        long end = System.currentTimeMillis();
        System.out.printf("总耗时：%d",end-begin);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        RealObejctProxy realObejctProxy = new RealObejctProxy(
            new RealObejct());
        realObejctProxy.show();
    }
}
