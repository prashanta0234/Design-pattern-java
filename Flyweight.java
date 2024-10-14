// Its cache the object and if some one want the same object again then its return from cache.
// when we use? Same object in multiple places, its increase performance, reuse object.
// components: Flyweight interface, Concrete Flyweight Classes,Flyweight Factory, Client

// Read this article : https://www.geeksforgeeks.org/flyweight-design-pattern/

// Flyweight interface
public interface Ball {
    void create();
}

// Concrete Flyweight Classes 1
public class CricketBall implements Ball {
    private String material;

    CricketBall(Object data) {
        try {
            System.out.println("Starting cricket ball");

            Thread.sleep(2000);  // Simulate some delay in creation
            this.material = (String) data;

            System.out.println("Created cricket ball");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public void create() {
        System.out.println("Cricket ball material is " + material);
    }
}

// Concrete Flyweight Classes 2
public class FootBall implements Ball {
    private int weight;

    FootBall(Object data) {
        try {
            System.out.println("Starting foot ball");

            Thread.sleep(2000);
            this.weight = (int) data;

            System.out.println("Created football");
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }


    @Override
    public void create() {
        System.out.println("Football weight is " + weight);
    }
}


// Flyweight Factory
import java.util.Map;
import java.util.HashMap;
public class BallFactory{
    Map<String, Ball> cache = new HashMap<>();
    
    public Ball getBall(String type){
        
        Ball ball = cache.get(type);

        
        switch(type) {
            case "cricket":
                if(cache.containsKey(type)){
                    ball= cache.get(type);
                }else{
                    Ball temp= new CricketBall("Leather");
                    cache.put(type, temp);
                    ball= temp;
                }
                
                break;
            default:
                if(cache.containsKey(type)){
                    ball= cache.get(type);
                }else{
                    Ball temp= new FootBall(32);
                    cache.put(type, temp);
                    ball= temp;
                }
                break;
        }
        
        return ball;

    }
  
    
}

// client
public class MyClass {
    public static void main(String args[]) {
        BallFactory factory = new BallFactory();
        
        Ball cricket1 = factory.getBall("cricket");
        Ball cricket2 = factory.getBall("cricket");
        Ball cricket3 = factory.getBall("cricket");
        
        Ball football1 = factory.getBall("football");
        Ball football2 = factory.getBall("football");
        
       

        // print all
        cricket1.create();
        cricket2.create();
        cricket3.create();
        
        football1.create();
        football2.create();
    }
}

