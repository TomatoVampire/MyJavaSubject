package WORK12;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.System.exit;

public class ReflectTest {
    public static void main(String[] args) {
        String[] ar = {"WORK12.StrList","s1","s2","s3"};

        Class<? extends List<String>> cl = null;
        try{
            cl = (Class<? extends List<String>>) Class.forName(ar[0]);
        }catch (ClassNotFoundException e){
            System.out.println("class ["+ar[0]+"] not found!");
            exit(1);
        }
        //get constructor
        Constructor<? extends List<String>> constructor = null;
        try {
            constructor = cl.getDeclaredConstructor();
        }catch (NoSuchMethodException e){
            System.out.println(e.getCause());
            exit(1);
        }

        //create
        List<String> list = null;
        try{
            list=constructor.newInstance();
        }catch (Exception e){
            System.out.println(e.getCause());
            exit(1);
        }
        //add str
        list.addAll(Arrays.asList(ar).subList(1,ar.length));
        System.out.println(list);
    }
}

class StrList extends ArrayList<String> {
    public StrList(){
        super();
    }
}
