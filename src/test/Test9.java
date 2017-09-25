package test;



class MyLinketStack<T>{
    class Node{
        T item;
        Node next;
        
        public Node(){
            this.item = null;
            this.next = null;
        }
        
        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
    
    Node top = new Node();
    
    public void push(T t){
        top = new Node(t,top);
    }
    
    
    public T pop(){
        T t = top.item;
        if(t!=null && top.next!=null)
            top = top.next;
        return t;
    }
}

public class Test9 {
    public static void main(String[] args) {
        MyLinketStack<String> s = new MyLinketStack<>();
        for (String str : "my name is lisheng".split(" ")) {
            s.push(str);
        }
        
        String temp;
        while((temp = s.pop())!=null){
            System.out.println(temp);
        }
    }
}
