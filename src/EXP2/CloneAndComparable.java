package EXP2;

public class CloneAndComparable {
    public static void main(String[] args)
    {
        Phone a = new Phone("HUAWEI",256,128);
        //clone复制
        Phone b = a.clone();
        Phone c = new Phone("XIAOMI",500,100);
        //拷贝构造
        Phone d = new Phone(c);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);

        System.out.println(a.compareTo(a));
        System.out.println(a.compareTo(c));
        System.out.println(c.compareTo(a));


        c.changeBrand("OnePlus");
        System.out.println(c);
        System.out.println(d);
    }
}

class Phone implements Cloneable,Comparable<Phone>
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

    //拷贝构造器
    public Phone(Phone phone)
    {
        //this = phone.clone();
        brand = phone.brand;
        screen = new Screen();
        screen.length = phone.screen.length;
        screen.width = phone.screen.width;
    }

    public void changeBrand(String s)
    {
        brand = s;
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
    public int compareTo(Phone p)
    {
        int r =  (int)(this.screen.width*this.screen.length - p.screen.width*p.screen.length);
        return r;
    }

    @Override
    public String toString()
    {
        return brand + " " + screen.length + " " + screen.width;
    }

}