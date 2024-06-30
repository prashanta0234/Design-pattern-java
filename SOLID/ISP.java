// Interface Segregation Principle (ISP)
// Definition: A client should never be forced to implement an interface that it doesn't use, or clients shouldn't be forced to depend on methods they do not use.

// violation of ISP

// Here we break ISP because we forcing Programmer to managing something but managing is not Programmers task its only for manager.

public interface Employee {
    void doWork();
    void manage();
}

public class Programmer implements Employee {
    @Override
    public void doWork() {
        System.out.println("Programmer is coding.");
    }

    @Override
    public void manage() {
        // Implementation not relevant for Programmer
        throw new UnsupportedOperationException("Programmers do not manage.");
    }
}

public class Manager implements Employee {
    @Override
    public void doWork() {
        System.out.println("Manager is managing tasks.");
    }

    @Override
    public void manage() {
        System.out.println("Manager is managing employees.");
    }
}


// To maintain the ISP:

// Here we are not force the Programmer to manage anything. 
public interface Workable {
    void doWork();
}

public interface Managable {
    void manage();
}

public class Programmer implements Workable {
    @Override
    public void doWork() {
        System.out.println("Programmer is coding.");
    }
}

public class Manager implements Workable, Managable {
    @Override
    public void doWork() {
        System.out.println("Manager is managing tasks.");
    }

    @Override
    public void manage() {
        System.out.println("Manager is managing employees.");
    }
}

