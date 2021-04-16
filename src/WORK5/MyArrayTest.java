package WORK5;

import java.util.ArrayList;
import java.util.List;

public class MyArrayTest {
    public static <E> void printArray(E[] a) {
        System.out.println(array2String(a));
    }

    public static <E> String array2String(E[] a) {
        String s ="";
        for (int i = 0; i < a.length; i++) {
            if (a[i] != null) {
                //System.out.print(a[i] + " ");
                s += (a[i] + " ");
            }
        }
        return s;
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
        s.remove(3);
        Integer[] ta = new Integer[10];
        ta = s.toArray(ta);
        printArray(ta);
    }
}

class MyArrayList<T>
{
    //暂时使用Object[]存
    Object[] list;
    int MAXSIZE = 50;
    protected int size;

    public MyArrayList()
    {
        list = new Object[MAXSIZE];
    }

    protected void extendSize()
    {
        System.out.println("extending maxsize to " + MAXSIZE*2);
        MAXSIZE *= 2;
        Object[] nlist = new Object[MAXSIZE];
        for(int i=0;i<size;i++)
        {
            nlist[i] = list[i];
        }
        list = nlist;
    }

    public void add(T e){
        if(size == MAXSIZE) extendSize();
        list[size++] = e;
    }

    public boolean remove(T e){
        for(int i=0;i<size;i++)
        {
            if(list[i].equals(e))
            {
                for(int j=i;j<size-1;j++)
                    list[j] = list[j+1];
                list[size--] = null;
                return true;
            }
        }
        return false;
    }

    public T get(int index){
        if(index >= size || index < 0) return null;
        return (T)list[index];
    }

    public int size()
    {
        return size;
    }

    public boolean contains(T e){
        for(int i=0;i<size;i++)
        {
            if(list[i].equals(e))
                return true;
        }
        return false;
    }

    public T[] toArray(T[] a) {
        int s = size;
        for(int i=0;i<s;i++)
        {
            T tmp = (T)list[i];
            a[i] = tmp;
        }
        return a;
    }


    @Override
    public String toString()
    {
        String s ="";
        for (int i = 0; i < size; i++) {
            if (list[i] != null) {
                //System.out.print(a[i] + " ");
                s += (list[i] + " ");
            }
        }
        return "My arraylist: "+ s;
    }

}