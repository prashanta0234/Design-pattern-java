// Definition: Objectpool pattern is a creational pattern. We will use object pool pattern when object creation is so much costly and we have to reuse it. 

// Like: Database connection, suppose we have db where our open ports is 5, so we can connect with 5 clients if one more client comes for make connection in that case we can`t able to make him connect. For solving this type of issue we can use Objectpool Pattern.

// key concepts:
// 1. Pooling: Instead of creating a new object each time one is needed, the object pool maintains a pool of available objects and provides a client with an instance from this pool. When the client is done with the object, it is returned to the pool for future use.
// 2. Reusability: By reusing objects, you can reduce the overhead of object creation and garbage collection, leading to improved performance and resource management.
// 3. Resource Management: The object pool can limit the number of objects that are active at any given time, helping to manage resources more effectively.


// Note: In Objectpool pattern we have to maintain Singleton pattern because of instance safety.


public class DatabaseConnection {
    private String connectionId;
    private boolean inUse;

    public DatabaseConnection() {
        this.connectionId = UUID.randomUUID().toString();
        this.inUse = false;
    }
}



public class ObjectPool {
    private int maxSize = 5;
    private int initialConnection =2;
    private List<DatabaseConnection> freeList=new ArrayList<Integer>();
    private List<DatabaseConnection> usedList=new ArrayList<Integer>();

    private ObjectPool instance; 

    private ObjectPool() {
       for(int i=0;i<initialConnection;i++){

        freeList.add(new DatabaseConnection());
       }
    }

    public ObjectPool getInstance(){
        if(instance == null){
            instance=new ObjectPool();
        }

        return instance;
    }

    public synchronized DatabaseConnection getDatabaseConnection() {

        if(freeList.isEmpty() && usedList.size()< maxSize){
            freeList.add(new DatabaseConnection());
            System.out.println("Create and add in free list.");
        }
        else if(freeList.isEmpty() && usedList.size==maxSize){
            System.out.println("No more connection is available please free a connection and assign it.");
            return null;
        }
        DatabaseConnection connection=freeList.remove(freeList.size()-1);

        usedList.add(connection);
        System.out.println("Used connection is: " + usedList.size());

         return connection;

    }

    public synchronized void freeConnection(DatabaseConnection connection) {
        if(connection !=null){
            usedList.remove(connection);
            freeList.add(connection);
            System.out.println("Removed a connection and add in freelist");
        }
    }

    public int getFreeSize() {
        return freeList.size();
    }
}


public class Client {
    public static void main(String[] args) {
        ObjectPool pool = DatabaseConnectionPool.getInstance();

        // Borrow connections from the pool
        DatabaseConnection conn1 = pool.getDatabaseConnection();
        DatabaseConnection conn2 = pool.getDatabaseConnection();

        // Print the connections
        System.out.println("Connection 1: " + conn1);
        System.out.println("Connection 2: " + conn2);


        // Borrow in this line send error
        DatabaseConnection conn3 = pool.getDatabaseConnection();

        pool.freeConnection(coon1);

        DatabaseConnection conn4 = pool.getDatabaseConnection();


        // Print the connections
        System.out.println("Connection 3: " + conn3);
        System.out.println("Connection 4: " + conn4);

        // Check the pool size
        System.out.println("Pool size: " + pool.getPoolSize());
    }
}



