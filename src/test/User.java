package test;
public class User{
    private static int count = 0;
    private final int id = count++;
    
    @Override
    public String toString() {
        return id+"";
    }
}