// The Liskov Substitution Principle (LSP) is one of the five SOLID principles of object-oriented design. It states that objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

// Break LSP:

// here we break LSP because when we want the squre its give us wrong ans we are passing height and width same because Square is a kind of  Rectangle but height and width is same.

class Rectangle {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getArea() {
        return width * height;
    }
}


class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width); // Ensuring the width and height are the same
    }

    @Override
    public void setHeight(int height) {
        super.setWidth(height);
        super.setHeight(height); // Ensuring the width and height are the same
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle area: " + rectangle.getArea()); // Output: 50

        Rectangle square = new Square();
        square.setWidth(5);
        square.setHeight(10); // This line will break LSP
        System.out.println("Square area: " + square.getArea()); // Output: 100, but logically expected: 50
    }
}


// For maintain the LSP:
// ex:

abstract class Shape {
    public abstract int getArea();
}

class Rectangle extends Shape {
    private int width;
    private int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

class Square extends Shape {
    private int side;

    public void setSide(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(5);
        rectangle.setHeight(10);
        System.out.println("Rectangle area: " + rectangle.getArea()); // Output: 50

        Square square = new Square();
        square.setSide(5);
        System.out.println("Square area: " + square.getArea()); // Output: 25
    }
}

