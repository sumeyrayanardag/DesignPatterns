
package singleton;

public class Main {
    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getSingleton();
        Singleton singleton2 = Singleton.getSingleton();
        
        System.out.println(singleton1 == singleton2); 
        //prints "true" because their address are same.
    }
}
