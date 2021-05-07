package WORK6;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StatisticsTest {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<Integer>();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);
        System.out.println(l);
        System.out.println(Statistics.max(l));
        System.out.println(Statistics.min(l));
        System.out.println(Statistics.middle(l));
        l.add(6);
        System.out.println(Statistics.middle(l));
    }
}

class Statistics
{
    //最大值
    public static <E extends Comparable<? super E>> E min(List<? extends E> src)
    {
        //int size = src.size();
        E temp = src.get(0);
        for(E e : src)
        {
            if(temp.compareTo(e) > 0)
                temp=e;
        }
        return temp;
    }
    // 返回列表最小值
    public static <E extends Comparable<? super E>> E max(List<? extends E> src) {
        //int size = src.size();
        E temp = src.get(0);
        for(E e : src)
        {
            if(temp.compareTo(e) < 0)
                temp=e;
        }
        return temp;
    }
    // 返回列表中位数
    public static <E extends Comparable<? super E>> E middle(List<? extends E> src) {
        int size = src.size();
        Collections.sort(src);
        //E temp = src.get(0);
        if(size % 2 == 0)
        {
            E a = src.get(size/2);
            E b = src.get(size/2 - 1);
            return a.compareTo(b) > 0?a:b;
        }
        else{
            return src.get(size/2);
        }
    }

}