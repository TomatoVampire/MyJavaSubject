package WORK3;
import java.util.*;
public class BoxTest {
    public static void main(String[] args)
    {
        Vector v = new Vector();
        v.add(3); v.add(4);

        BigBox<Integer> box = new BigBox<Integer>();
        box.add(1);
        box.add(2);
        System.out.println(box);
        box.addAll(v);
        System.out.println(box);

        BIGBOX<Integer> boxx = new BIGBOX<Integer>();
        boxx.add(5);
        boxx.add(6);
        boxx.addAll(v);
        System.out.println(boxx);
    }
}


class Box<E>
{
    private Vector<E> v;
    public Box() {
        v = new Vector<E>();
    }
    void add(E s) {
        v.addElement(s);
    }
    void addAll(Vector<E> hs) {
        for (int i = 0; i < hs.size(); ++i) {
            add(hs.get(i));
        }
    }

    @Override
    public String toString()
    {
        return v.toString();
    }

}

class BIGBOX<E>
{
    private Box<E> box;
    private int addCount=0;

    public BIGBOX(){box = new BigBox<E>();}
    public void add(E s){box.add(s);addCount++;}
    public void addAll(Vector<E> hs){box.addAll(hs);addCount+=hs.size();}
    @Override
    public String toString(){return Integer.toString(addCount) + " " + box.toString();}
}

class BigBox<E> extends Box<E> {
    private int addCount=0;
    @Override
    void add(E s)
    {
        addCount++;
        super.add(s);
    }

    @Override
    void addAll(Vector<E> hs)
    {
        super.addAll(hs);
    }

    @Override
    public String toString()
    {
        return Integer.toString(addCount) + " " + super.toString();
    }
}



