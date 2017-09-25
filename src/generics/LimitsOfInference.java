package generics;
//: generics/LimitsOfInference.java
import typeinfo.pets.*;

import java.util.*;

import net.mindview.util.New;

public class LimitsOfInference {
   void
  f(Map<Person, List<? extends Pet>> petPeople) {}
  
  public  void main(String[] args) {
     f(New.<Person, List<? extends Pet>>map()); // Does not compile
  }
} ///:~
