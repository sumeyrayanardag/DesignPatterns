
package singleton;

//The goal is to create only one instance of a class. 
//Logger is a good example for singleton pattern.
public class Singleton {
    
    private static Singleton singleton = new Singleton();
    
    private Singleton(){       
    }
    
    public static Singleton getSingleton(){
        return singleton;
    }
}
