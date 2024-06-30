// Definition: The Factory Pattern is a creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. This pattern encapsulates the instantiation process and defines an interface for creating an object, but lets subclasses decide which class to instantiate.

// Components: 1. Product Interface, 2. ConcreteProduct, 3.Creator Factory Class, 4.ConcreteCreator (client)


// use case: Managing create complex objects, Reusability

// Product interface
public interface Button {
    void render();
    
}

// ConcreteProduct
public class PrimaryButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Primary button.Color is blue");
    }

}

public class AlertButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Alert button. Color is red.");
    }

}

public class SuccessButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Success button. Color is Green.");
    }

}


// Creator Factory Class
public class FactoryButton{
    private Button pButton;

    public FactoryButton(String type) {
        if (type == "primary") {
            pButton= new PrimaryButton();
        } else if (type == "alert") {
            pButton = new AlertButton();
        }else if(type == "success"){
            pButton= new SuccessButton();
        }
        else {
            pButton = null;
        }
    }
    
    
    public Button getButton(){
        return pButton;
    }

}

// ConcreteCreator (client)

class Client{
    public static void main(String[] args){
        FactoryButton button1=new FactoryButton("primary");
        FactoryButton button2=new FactoryButton("alert");
        FactoryButton button3=new FactoryButton("success");
        
        
        
        Button primay=button1.getButton();
        Button alert=button2.getButton();
        Button success=button3.getButton();
        
        primay.render();
        alert.render();
        success.render();

    }
}

