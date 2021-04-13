package EXP1;

import java.util.ArrayList;

public class Q1 {
    public static void main(String[] args)
    {
        GamingLaptop gl = new GamingLaptop.Builder().setCPU("AMD Ryzen R7").setGPU("MX250").setNvidiaGPU("Geforce RTX 3060").
                setHertz(3).setRAM(16).
                addExternalInterface("USB","HDMI").build();
        System.out.println(gl);
        Surface sl = new Surface.Builder().setCPU("Core i7 4700").setHertz(2).
                setGPU("MX250").setRAM(8).
                addExternalInterface("USB","HDMI","PD").
                setSafeMode(true).build();
        //System.out.println(sl);
        Laptop cl = gl.clone();
        //gl = null;//delete
        cl.addExternalInterface("Type-c");
        System.out.println((Laptop)cl);
        System.out.println(gl);
        System.out.println(gl.compareTo(sl));
    }
}

abstract class Laptop implements Cloneable, Comparable<Laptop>
{
    protected final String mCPU;
    protected final int mHertz;
    protected final String mGPU;
    protected final int mRAM;
    protected ArrayList<String> mExternalInterface;

    //并不带clone方法！！
    public abstract static class Builder<T extends Laptop.Builder<T>>// implements Cloneable
    {
        protected String CPU;
        protected String GPU;
        protected int Hertz,RAM;
        protected ArrayList<String> Interface;
        public Builder()
        {
            CPU = GPU = "";
            Hertz = RAM = 0;
            Interface = new ArrayList<>();
        }

        public T setCPU(String name)
        {
            CPU = name;
            return self();
        }

        public T setGPU(String name)
        {
            GPU = name;
            return self();
        }

        public T setHertz(int i)
        {
            Hertz = i;
            return self();
        }

        public T setRAM(int i)
        {
            RAM = i;
            return self();
        }

        //不定长参数
        public T addExternalInterface(String ... inter)
        {
            //String t;
            for(String t : inter)
            {
                Interface.add(t);
            }
            //Interface.add(inter);
            return self();
        }

        public abstract T self();//todo: return the derived builder
        //todo:public Typename build();

       /* @Override
        public  clone()
        {
            try {
                return (T) super.clone();
            } catch(CloneNotSupportedException e) {
                throw new AssertionError(); // Can't happen
        }*/
    }

    protected Laptop(Builder<?> builder)
    {
        mCPU = builder.CPU;
        mGPU = builder.GPU;
        mHertz = builder.Hertz;
        mRAM = builder.RAM;
        mExternalInterface = builder.Interface;
    }

    public void addExternalInterface(String ... group)
    {
        for(String t : group)
            mExternalInterface.add(t);
    }

    @Override
    public String toString()
    {
        return "CPU: " + mCPU + "\n" +
                "Hertz: " + mHertz + "\n" +
                "GPU: " + mGPU + "\n" +
                "RAM: " + mRAM + "\n" +
                "Extern Interface: " + mExternalInterface + "\n" +
                "hashCode: " + hashCode() + "\n";
    }

    @Override
    public boolean equals(Object o)
    {
        if(o instanceof Laptop)
        {
            if(o == this) return true;
            Laptop obj = (Laptop) o;
            return mCPU.equals(obj.mCPU) && mGPU.equals(obj.mGPU) &&
                    mHertz == obj.mHertz && mRAM == obj.mRAM &&
                    mExternalInterface.equals(obj.mExternalInterface);
        }
        else
            return false;
    }

    @Override
    public int hashCode()
    {
        int result = mExternalInterface.hashCode();
        result += 31*result + mGPU.hashCode();
        result += 31*result + mCPU.hashCode();
        result += 31*result + Integer.hashCode(mHertz);
        result += 31*result + Integer.hashCode(mRAM);
        return result;
    }

    @Override
    public Laptop clone(){
        try {
            Laptop temp =  (Laptop) super.clone();
            //todo: deep clone arraylist!!
            ArrayList<String> nlist = new ArrayList<>();
            for(String t : mExternalInterface)
            {
                nlist.add(t);
            }
            temp.mExternalInterface = nlist;
            return temp;//(Laptop) super.clone();
        } catch(CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }

    //=自己主频-参数主频
    @Override
    public int compareTo(Laptop p)
    {
        return this.mHertz - p.mHertz;
    }

}

class GamingLaptop extends Laptop
{
    protected final String mNvidiaGPU;
    public static class Builder extends Laptop.Builder<Builder>
    {
        protected String NGPU;
        public Builder()
        {
            super();
            NGPU = "";
        }

        public Builder setNvidiaGPU(String GPU)
        {
            NGPU = GPU;
            return this;
        }

        @Override
        public Builder self(){return this;}

        public GamingLaptop build()
        {
            GamingLaptop m = new GamingLaptop(this);
            return m;
        }
    }

    protected GamingLaptop(Builder builder)
    {
        super(builder);
        mNvidiaGPU = builder.NGPU;
    }

    @Override
    public String toString()
    {
        String ap = "Gaming Laptop\nNvidia GPU: " + mNvidiaGPU + "\n";
        return ap + super.toString();
    }

    @Override
    public boolean equals(Object o)
    {
        if(!super.equals(o)) return false;
        if(o instanceof GamingLaptop)
        {
            if(o == this) return true;
            GamingLaptop obj = (GamingLaptop) o;
            return mNvidiaGPU.equals(obj.mNvidiaGPU);
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result += 31*result + mNvidiaGPU.hashCode();
        return result;
    }

    @Override
    public GamingLaptop clone()
    {
        //无需写Try?
        return (GamingLaptop) super.clone();
    }
}

class Surface extends Laptop
{
    protected boolean mIsSafeModeOn;
    public static class Builder extends Laptop.Builder<Builder>
    {
        protected boolean SafeMode;
        public Builder()
        {
            super();
            SafeMode = false;
        }

        public Builder setSafeMode(boolean mode)
        {
            SafeMode = mode;
            return this;
        }

        @Override
        public Builder self(){return this;}

        public Surface build()
        {
            return new Surface(this);
        }
    }

    protected Surface(Builder build)
    {
        super(build);
        mIsSafeModeOn = build.SafeMode;
    }

    @Override
    public String toString()
    {
        String m = "Surface\nSafe mode: " + mIsSafeModeOn + "\n";
        return m + super.toString();
    }

    @Override
    public int hashCode()
    {
        int result = super.hashCode();
        result = 31*result + Boolean.hashCode(mIsSafeModeOn);
        return result;
    }

    @Override
    public Surface clone()
    {
        return (Surface) super.clone();
    }
}