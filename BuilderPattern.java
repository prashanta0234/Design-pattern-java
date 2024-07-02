// Definition: Builder pattern helps us to create complex objects step by step. 

// in our code we try to create a computer in this computer class we create a computerBuilder class for configure the computer.

// why i use Builder pattern: Look when we buy a computer sometimes we don`t need to add graphics card, or other optional parts. if i want to use other pattern i have to pass everything with optional parts when i create computer class. 


public class Computer {
    
    private String type;
    private String ram;
    private String rom;
    private boolean graphicsCard;
    
    public String getComputerType(){
        return type;
    }
    
    public String getComputerRam(){
        return ram;
    }
    
    public String getComputerRom(){
        return rom;
    }
    
    public boolean getComputerGraphics(){
        return graphicsCard;
    }
    
    public String getConfig(){
        return "Type:" +type + ", "+"Ram:"+ram;
    }
    
    private Computer(ComputerBuilder builder){
        this.type=builder.type;
        this.ram=builder.ram;
        this.rom=builder.rom;
        this.graphicsCard=builder.graphicsCard;
    }
    public static class ComputerBuilder{
        private String type;
        private String ram;
        private String rom;
        private boolean graphicsCard;
        
        public ComputerBuilder(String type){
            this.type=type;
        }
        
        public ComputerBuilder setRam(String ram){
            this.ram=ram;
            return this;
        }
        
        public ComputerBuilder setRom(String rom){
            this.rom=rom;
            return this;
        }
        
        public ComputerBuilder setGraphics(boolean graphicsCard){
            this.graphicsCard=graphicsCard;
            return this;
        }
        
        public Computer build(){
			return new Computer(this);
		}
    }
}

class TestingBuilder{
    public static void main(String[] args){
        Computer comp=new Computer.ComputerBuilder("desktop").setGraphics(true).setRam("100 GB").build();
        System.out.print(comp.getConfig());
    }
}