// Definition: The dependency inversion principle is a design principle that states that high-level modules should depend on abstractions rather than concrete implementations. This helps decouple the high-level and low-level modules, making it easier to change the low-level ones without affecting the high-level ones.


// Note: It`s make easy to maintain a software.
// Here our higher module depends on lower module so we break the DIP


// Lower module
class Light {
    public void turnOn() {
        System.out.println("Light is turned on.");
    }

    public void turnOff() {
        System.out.println("Light is turned off.");
    }
}

// Lower module
class Button {
    private Light light;


    public Button(Light light) {
        this.light = light;
    }


    public void press() {
        if (light != null) {
            light.turnOn();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Button lightButton = new Button(light);
        lightButton.press(); // Output: Light is turned on.

    }
}

// if we try to add another lower level module we have to change the higher level module
// ex: 
class Fan {
    public void turnOn() {
        System.out.println("Fan is turned on.");
    }

    public void turnOff() {
        System.out.println("Fan is turned off.");
    }
}
class Light {
    public void turnOn() {
        System.out.println("Light is turned on.");
    }

    public void turnOff() {
        System.out.println("Light is turned off.");
    }
}

class Button {
    private Light light;
    private Fan fan;
    private boolean isLightControl;

    public Button(Light light) {
        this.light = light;
        this.isLightControl = true;
    }

    public Button(Fan fan) {
        this.fan = fan;
        this.isLightControl = false;
    }

    public void press() {
        if (isLightControl && light != null) {
            light.turnOn();
        } else if (!isLightControl && fan != null) {
            fan.turnOn();
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Button lightButton = new Button(light);
        lightButton.press(); // Output: Light is turned on.

        Fan fan = new Fan();
        Button fanButton = new Button(fan);
        fanButton.press(); // Output: Fan is turned on.
    }
}


// Solutions: 

// Abstraction
interface Switchable {
    void turnOn();
    void turnOff();
}

// Low-level modules
class Light implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Light is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Light is turned off.");
    }
}

class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Fan is turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Fan is turned off.");
    }
}

// High-level module
class Button {
    private Switchable switchable;

    public Button(Switchable switchable) {
        this.switchable = switchable;
    }

    public void press() {
        if (switchable != null) {
            switchable.turnOn();
        }
    }
}

// Main class to demonstrate the usage
public class Main {
    public static void main(String[] args) {
        Switchable light = new Light();
        Button lightButton = new Button(light);
        lightButton.press(); // Output: Light is turned on.

        Switchable fan = new Fan();
        Button fanButton = new Button(fan);
        fanButton.press(); // Output: Fan is turned on.
    }
}
