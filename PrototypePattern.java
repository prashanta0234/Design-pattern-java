// Definition: when object creation and get data from somewhere is expensive in this situation we will use Prototype pattern. In prototype we create a object one time and if we need this object later we clone previous object and modify on it or use it.


public class Computer {
    
    private String type;
    private String ram;
    private String rom;

    public Computer(String type,String ram,String rom){
        this.type=type;
        this.ram=ram;
        this.rom=rom;
    }
    
    
    public Computer clone(){
        return new Computer(this.type,this.ram,this.rom);
    }
    
    public String printObject(){
        return "Type: "+ type +", "+"Ram: "+ ram+", "+"Rom: "+rom;
    }
}

class TestingPrototype{
    public static void main(String[] args){
        Computer comp=new Computer("Laptop","16 GB","500 GB");
        
        Computer comp1= comp.clone();
        Computer comp2= comp.clone();
        
        System.out.println(comp.printObject());
        System.out.println(comp1.printObject());
        System.out.println(comp2.printObject());
    }
}