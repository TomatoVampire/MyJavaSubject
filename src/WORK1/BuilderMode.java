package WORK1;

public class BuilderMode {
    public static void main(String[] args)
    {
        TallPerson t = new TallPerson.Builder("Tom").setArms(2).setLegs(2).setHeight(1.5f).build();
        WidePerson w = new WidePerson.Builder("Saya").setArms(2).setWeight(120f).setLegs(2).build();
        System.out.println(t);
        System.out.println(w);
    }
}

abstract class Person
{
    final String mName;
    final int mHead;
    final int mBody;
    final int mArms;
    final int mLegs;
    public abstract static class Builder<T extends Builder<T>>//T为Person的子类的Builder
    {
        final String name;
        int head;
        int body;
        int arms;
        int legs;
        public Builder(String n)
        {
            name = n;
            head=1;
            body=1;
            arms=0;
            legs=0;
        }
        public T setArms(int n)
        {
            arms=n;
            return self();
        }
        public T setLegs(int n)
        {
            legs=n;
            return self();
        }
        /*public T build()
        {
            return self();
        */
        //todo
        public abstract T self();
    }
    protected Person(Builder<?> builder)
    {
        mName=builder.name;
        mArms=builder.arms;
        mBody=builder.body;
        mHead=builder.head;
        mLegs=builder.legs;
    }
    @Override
    public String toString()
    {
        return "Person";//??
    }
}

class TallPerson extends Person
{
    final float mHeight;
    public static class Builder extends Person.Builder<Builder>
    {
        float height;
        public Builder(String n)
        {
            super(n);
            height=0;
        }
        public Builder setHeight(float n)
        {
            height=n;
            return this;
        }
        //@Override
        public TallPerson build()
        {
            TallPerson p = new TallPerson(this);
            return p;
        }
        @Override
        public Builder self()
        {
            return this;
        }
    }
    protected TallPerson(Builder builder)
    {
        super(builder);
        mHeight=builder.height;
    }
    @Override
    public String toString()
    {
        return "Tall person: " + mName + " Height: " + mHeight;//??
    }
}

class WidePerson extends Person
{
    final float mWeight;
    public static class Builder extends Person.Builder<Builder>
    {
        float weight;
        public Builder(String n)
        {
            super(n);
            weight=0;
        }
        public Builder setWeight(float n)
        {
            weight = n;
            return this;
        }

        public WidePerson build()
        {
            return new WidePerson(this);
        }
        @Override
        public Builder self(){return this;}
    }
    protected WidePerson(Builder builder)
    {
        super(builder);
        mWeight=builder.weight;
    }
    @Override
    public String toString()
    {
        return "Wide Person: "+ mName + " Weight: " + mWeight;//??
    }
}
