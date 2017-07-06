package test;
public class Test1 {
    public static User createUser(String name,boolean isCreate){
        User user = null;
        if(isCreate){
            class Person implements User{
                private String name;
    
                private Person(String name){
                    this.name = name;
                }
                
                @Override
                public String getName() {
                    return this.name;
                }
            }
            user = new Person(name);
        }
        return user;
    }
    
    public static void main(String[] args) {
        User user = createUser("lis",true);
        String name = user.getName();
        System.out.println(name);
    }
}

interface User{
    String getName();
}
