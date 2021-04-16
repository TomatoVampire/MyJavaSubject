package WORK5;

import java.util.ArrayList;
import java.util.List;

public class MyArrayTest {
    public static <E> void printArray(E[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                System.out.print(a[i] + " ");
            }
        }
    }

    public static void main(String[] args)
    {
        MyArrayList<Integer> s = new MyArrayList<>();
        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);

        System.out.println(s);
        System.out.println(s.contains(3));
        s.add(5);
        s.remove(4);
        s.remove(6);
        Integer[] ta = new Integer[10];
        ta = s.toArray(ta);
        printArray(ta);
    }
}

class MyArrayList<T>
{
    //暂时使用Object[]存
    Object[] list;
    final int MAXSIZE = 50;

    public MyArrayList()
    {
        list = new Object[MAXSIZE];
    }

    public void add(T e){
        list.add(e);
    }

    public boolean remove(T e){
        return  list.remove(e);
    }

    public T get(int index){
        if(index >= list.size() || index < 0) return null;
        return list.get(index);
    }

    public int size()
    {
        return list.size();
    }

    public boolean contains(T e){
        return list.contains(e);
    }

    public T[] toArray(T[] a) {
        int s = size();
        for(int i=0;i<s;i++)
        {
            T tmp = get(i);
            a[i] = tmp;
        }
        return a;
    }

    @Override
    public String toString()
    {
        return "My arraylist: "+ list.toString();
    }

}