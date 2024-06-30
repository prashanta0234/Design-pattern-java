// definition: In singleton pattern we will have only one instance for whole application and have a access point to access the instance in the application.

// Note: Must be one instance.

// useCase: When we need a single instance for all classes we can use singleton pattern, if we sure that we will have only instance in my whole application in that case we will use Singleton patter.

public class Singleton{
    
    private static Singleton instance;     // instance is privet so that no one can access it.
    
    private Singleton(){}   // constructor is also privet because we don`t give permission to other classes to create any instance, and its empty because instance will create on-demand
    

    // access point
    public static Singleton getInstance(){
        if(instance == null){
            instance= new Singleton();
            // we must have to create instance on demand;
        }
        
        return instance;
    }
    
    public static void main(String[] args){
        
    }
}

// others class
public class Client {
    public static Singleton ins= Singleton.getInstance(); // create 1st time
    public static Singleton ins1= Singleton.getInstance(); // create 2nd time
    
    public static void main(String[] args){
        // we are getting true because instance is create only one time ins singleton class, if we access it multiple time the instance will be same in everywhere.
        if(ins==ins1){
            System.out.print("ins and ins1 are same");
        }
    }
}