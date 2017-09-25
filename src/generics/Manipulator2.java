package generics;

import java.util.Arrays;
//: generics/Manipulator2.java

class Manipulator2<T extends HasF> {
  private T obj;
  public Manipulator2(T x) { obj = x; }
  public void manipulate() { obj.f(); }
  
  public static void main(String[] args) {
    Manipulator2<HasF> manipulator2 = new Manipulator2<HasF>(new HasF());
    System.out.println(Arrays.toString(manipulator2.getClass().getTypeParameters()));
}
} ///:~

