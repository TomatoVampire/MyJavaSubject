package WORK3;

public class Math {
    public static final double PI = 3.141592653;
    public static double getPI() { return PI; }
    public static void main(String[] args)
    {
        Cylinder a = new Cylinder(3,4);
        Cone b = new Cone(3,4);
        double c = b.volume();
        System.out.println(a.volume());
        System.out.println(b.volume());

    }
}

abstract class Primitive
{
    abstract double volume();
}

class Cylinder extends Primitive
{
    private double r;
    private double h;
    public Cylinder(double r,double h)
    {
        this.r = r;
        this.h = h;
    }

    @Override
    double volume()
    {
        return r * h * Math.getPI();
    }
}

class Cone extends Primitive
{
    private double r;
    private double h;
    public Cone(double r,double h)
    {
        this.r = r;
        this.h = h;
    }
    @Override
    double volume()
    {
        return 1.0/3 * r * h * Math.getPI();
    }
}
