// Single Responsibility Principle (SRP)

// Definition: Every class/method used for specific work, and changes for specific reason.


// here we break SRP Principal because we use Math class for add and sub.
class Math{
    int add(int a,int b){
        return a+b;
    }
    int sub(int a, int b){
        return a-b;
    }
}

// here we don`t break SRP because we use Add for add 2 numbers and Sub class for sub 2 numbers

class Add{
    int a;
    int b;

    public Add(int a,int b){
        this.a=a;
        this.b=b;
    }

    int result(){
        return a+b;
    }
}

class Sub{
    int a;
    int b;

    public Sub(int a,int b){
        this.a=a;
        this.b=b;
    }

    int result(){
        return a-b;
    }
}