package EXP1;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class StaticFactory {
    public static void main(String[] args)
    {
        Cat c = new Cat();
        Dog d = new Dog();
        AnimalFactory.register("Tom",c);
        AnimalFactory.register("Edward",d);
        Animal t;
        t=AnimalFactory.getAnimal("Tom");
        if(t != null) System.out.println(t.getName());
        t=AnimalFactory.getAnimal("Edward");
        if(t != null) System.out.println(t.getName());

        t=AnimalFactory.getAnimal("unexisted");
        if(t != null) System.out.println(t.getName());
    }
}

interface Animal
{
    String getName();
}
class Cat implements Animal
{
    public String getName()
    {
        String n = new String("Cat");
        return n;
    }
}
class Dog implements Animal
{
    public String getName()
    {
        return "Dog";
    }
}

class AnimalFactory
{
    static final Map<String,Animal> animals = new ConcurrentHashMap<String, Animal>();
    //todo:注册名字-Animal接口进map
    public static void register(String name,Animal animal)
    {
        animals.put(name,animal);
    }
    public static Animal getAnimal(String n)
    {
        Animal a = animals.get(n);
        if(a == null) {
            System.out.println("cannot find animal '" + n+"'");
        }
        return a;
    }
}