package EXP1;

public class Singleton {
    public static void main(String[] args)
    {
        Emperor.getInstance().print();
    }

}

class Emperor
{
    private static Emperor INSTANCE = new Emperor();
    private static String Name;
    private static String Dynasty;
    public static Emperor getInstance(){return INSTANCE;}
    private Emperor()
    {
        Name="朱元璋";
        Dynasty="明朝";
    }
    public static void print()
    {
        System.out.println("朝代为："+Dynasty+" 皇帝为："+Name);
    }
}
