package EXP2;

public class CloneAndComparable {
    public static void main(String[] args)
    {
        Phone a = new Phone("HUAWEI",256,128);
        Phone b = a.clone();
        Phone c = new Phone("XIAOMI",500,100);
        System.out.println(a);
        System.out.println(b);
    }
}

class Phone implements Cloneable
{
    String brand;
    Screen screen;

    protected static class Screen implements Cloneable {
        float length, width;

        @Override
        public Screen clone() {
            try {
                return (Screen) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }

    public Phone(String name,float length,float width)
    {
        brand=name;
        screen = new Screen();
        screen.length=length;
        screen.width=width;
    }

    @Override
    public Phone clone()
    {
        try {
            //Phone r = (Phone) super.clone();
            //r.screen = screen.clone();
            //return r;
            return (Phone) super.clone();
        }catch(CloneNotSupportedException e)
        {
            throw new AssertionError();
        }
    }

    @Override
    public String toString()
    {
        return brand + " " + screen.length + " " + screen.width;
    }

}