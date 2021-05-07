package WORK5;

public class SortTest {
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
        Integer[] a = {1,4,3,2,6,5};
        printArray(a);
        Sorter<Integer> s = new Sorter<>(a);
        s.sort();
        System.out.println(s);
    }


}

class Sorter<E extends Comparable<? super E>>
{
    Object[] list;
    private int MAXSIZE = 5;
    private int size=0;
    private void extendSize()
    {
        MAXSIZE*=2;
        Object[] n=new Object[MAXSIZE];
        int i=0;
        for(Object e : list)
        {
            n[i++] = e;
        }
        list = n;
    }

    public Sorter(E[] src)
    {
        list = new Object[MAXSIZE];
        size = src.length;
        while (MAXSIZE < size)
        {
            extendSize();
        }
        int i=0;
        for(E e : src)
        {
            list[i++] = e;
        }
    }

    //冒泡排序？
    public void sort()
    {
        for(int i=0;i<size;i++)
        {
            for(int j=0;j<i;j++)
            {
                E x = (E)list[j];
                E y = (E)list[j+1];
                if(x.compareTo(y) > 0)
                {
                    swap(j, j+1);
                }
            }
        }
    }

    private void swap(int i,int j)
    {
        Object t = list[i];
        list[i] = list[j];
        list[j] = t;
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
        return "Sorter: "+ s;
    }

}