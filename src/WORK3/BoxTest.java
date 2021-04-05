package WORK3;
import java.util.*;
public class BoxTest {
    public static void main(String[] args)
    {
        Vector v = new Vector();
        v.add(3);
        v.add(4);

        BigBox<Integer> box = new BigBox<>();
        box.add(1);
        box.add(2);
        System.out.println(box);
        box.addAll(v);
        System.out.println(box);
    }
}


class Box<E> {
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
        //String a = addCount + " " + v;
        Integer i = addCount;
        return i.toString() + " " + super.toString();
    }
}
