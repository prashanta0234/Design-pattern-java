// Open Close Principle (OCP)

// Definition: Open for extension and closed for modification


// violation  of OCP

public class Shape {
    public void draw(String shapeType) {
        if (shapeType.equals("Circle")) {
            drawCircle();
        } else if (shapeType.equals("Rectangle")) {
            drawRectangle();
        }
    }

    private void drawCircle() {
        System.out.println("Drawing a Circle");
    }

    private void drawRectangle() {
        System.out.println("Drawing a Rectangle");
    }
}

//  in Shape class if we try to add a new shape we have to modification the Shape so its break the OCP.

// ex:
public class Shape {
    public void draw(String shapeType) {
        if (shapeType.equals("Circle")) {
            drawCircle();
        } else if (shapeType.equals("Rectangle")) {
            drawRectangle();
        } else if (shapeType.equals("Triangle")) {
            drawTriangle();
        }
    }

    private void drawCircle() {
        System.out.println("Drawing a Circle");
    }

    private void drawRectangle() {
        System.out.println("Drawing a Rectangle");
    }

    private void drawTriangle() {
        System.out.println("Drawing a Triangle");
    }
}


// #########################################################
// For maintain the OCP we can implement like:

public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}


public class DrawingApp {
    public void drawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        DrawingApp app = new DrawingApp();

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        app.drawShape(circle);
        app.drawShape(rectangle);
    }
}

// now if we want to add a new shape its don`t break the OCP

// ex: 

public interface Shape {
    void draw();
}

public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Rectangle");
    }
}

public class Triangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a Triangle");
    }
}


public class DrawingApp {
    public void drawShape(Shape shape) {
        shape.draw();
    }

    public static void main(String[] args) {
        DrawingApp app = new DrawingApp();

        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape triangle = new Triangle();

        app.drawShape(circle);
        app.drawShape(rectangle);
        app.drawShape(triangle);
    }
}