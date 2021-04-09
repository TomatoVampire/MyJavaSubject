package WORK4;

public class SkeletonTest {
    public static void main(String[] args)
    {
        Cat c = new Cat("Tom");
        c.eat();
        c.jump();
        c.run();
        c.call();
        System.out.println(c.getName());
    }
}

interface Animal
{
    void call();
    void eat();
    void run();
    void jump();
}

abstract class AbstractAnimal implements Animal
{
    protected String name;
    public String getName(){return name;}
    @Override
    public void eat()
    {
        System.out.println("num num num...");
    }

    @Override
    public void call()
    {
        System.out.println("Call!");
    }
}

class Cat extends AbstractAnimal
{
    @Override
    public void run()
    {
        System.out.println("Running...");
    }
    @Override
    public void jump()
    {
        System.out.println("Jump!");
    }
    public Cat(String n)
    {
        name = n;
    }

}