package test;
public class Test6 {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer();
        for(int i=0; i<10; i++){
            stringBuffer.append(i);
        }
        System.out.println(stringBuffer.toString());
    }
}
