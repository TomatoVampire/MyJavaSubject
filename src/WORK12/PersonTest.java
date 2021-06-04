package WORK12;

public class PersonTest {
    public static void main(String[] args) {
        Person p = new Person("xiao",-5);
    }
}

class Person{
    String name;
    int age;
    public Person(String n, int a){
        if(a < 0) throw new IllegalAgeException(a);
            age = a;
            name = n;
    }
}

class IllegalAgeException extends IllegalArgumentException{
    public IllegalAgeException(int arg){
        //if(arg < 0) System.out.println("age "+ arg+" is not a valid number! Should be above 0!");
        super("age "+ arg+" is not a valid number! Age should be above 0!");
    }
}