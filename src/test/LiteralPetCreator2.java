package test;

import typeinfo.pets.LiteralPetCreator;

public class LiteralPetCreator2 extends LiteralPetCreator{
    public static void main(String[] args) {
        String a = new BB().b.toString();
        System.out.println(a);
        new BB().show();
    }
}

class AA{
  public  final static  String a  = "AA";
  public static void show(){
      System.out.println("my AAAA");
  }
}

class BB extends AA{
     StringBuffer b  = new StringBuffer("");
    BB(){
      b = b.append(super.a);
    }
    public void show2(){
        System.out.println(super.a);
    }
}

class CC extends BB{
    public void show2(){
        
    }
}