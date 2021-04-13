package EXP1;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
//import java.util.Map;

public class Q2 {
    public static void main(String[] args)
    {
        Office f = new Office(Office.OfficeType.POWERPOINT);
        Office f2 = new Office(Office.OfficeType.WORD);
        Steam s = Steam.getInstance();
        s.addWishlist("DMC5", "HITMAN3","Cyberpunk2077");
        ApplicationFactory.Register("PR",f);
        ApplicationFactory.Register("EXP report",f2);
        ApplicationFactory.Register("Steam",s);

        ApplicationFactory.runApplication("Steam").run();
        ApplicationFactory.runApplication("PR").run();
        ApplicationFactory.runApplication("EXP report").run();
    }
}

interface Application
{
    void run();
}

class ApplicationFactory
{
    //根据输入的参数创建响应对象
    public static enum APPType
    {
        OFFICE,STEAM
    }
    private static Map<String, Application> appList = new ConcurrentHashMap<>();
    public static void Register(String name,Application t) {
        appList.put(name,t);
    }
    public static Application runApplication(String name) {
        return appList.get(name);
    }
}

class Office implements Application
{
    public static enum OfficeType
    {
        WORD,EXCEL,POWERPOINT,OUTLOOK
    }

    private OfficeType type;

    public Office()
    {
        type = OfficeType.WORD;
    }
    public Office(OfficeType s)
    {
        setType(s);
    }

    public void setType(OfficeType s)
    {
        type = s;
    }


    @Override
    public void run()
    {
        System.out.println("Start running Office app: " + type);
    }
}

class Steam implements Application
{
    private static Steam instance = new Steam();
    public static Steam getInstance() { return instance; }
    private ArrayList<String> wishlist;

    private Steam()
    {
        wishlist = new ArrayList<>();
    }

    @Override
    public void run() {
        System.out.println("Start running Steam wishlist: " + wishlist);
    }

    public String getWishlist()
    {
        return wishlist.toString();
    }

    public void addWishlist(String ... game)
    {
        for(String s : game)
            wishlist.add(s);
    }
}
