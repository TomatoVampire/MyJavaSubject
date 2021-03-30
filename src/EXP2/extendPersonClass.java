package EXP2;


public class extendPersonClass {
    public static void main(String[] args)
    {
        Person a = new Person("1","小红",15,"学生");
        Person b = new Person("2","小丽",18,"学生");
        Person c = a;
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(a);
        System.out.println(b);

    }
}

class Person
{
    protected String id,name,job;
    protected int age;

    public Person(String id,String name,int age,String job)
    {
        this.id = id;
        this.name=name;
        this.age=age;
        this.job=job;
    }


    @Override
    public boolean equals(Object o)
    {
        if( o == this) return true;
        if(o instanceof Person)
        {
            Person r = (Person) o;
            return r.id.equals(id) && r.name.equals(name) && r.job.equals(job) && r.age == age;
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        int result = Integer.hashCode(age);
        result += 31*result + name.hashCode();
        result += 31*result + job.hashCode();
        result += 31*result + id.hashCode();
        return result;
    }

    @Override
    public String toString()
    {
        return id+"　"+name+" "+age+" "+job + " @"+hashCode();
    }
}
