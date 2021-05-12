package WORK6;
import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args){
        HashSet<Integer> a = new HashSet<>();
        a.add(1);
        a.add(2);
        a.add(4);
        HashSet<Integer> b = new HashSet<>();
        b.add(1);
        b.add(3);
        b.add(5);
        System.out.println("a："+a);
        System.out.println("b："+b);

        Set<Integer> u = SetOperation.union(a,b);
        System.out.println("并集："+u);
        Set<Integer> i = SetOperation.intersection(a,b);
        System.out.println("交集：" + i);
    }
}

class SetOperation
{
    // 返回集合的并集
    public static <E> Set<E> union(Set<? extends E>... sets) {
        Set<E> temp = new HashSet<>();
        for(Set<? extends E> s : sets)
        {
            temp.addAll(s);
        }
        return temp;
    }
    // 返回集合的交集
    public static <E> Set<E> intersection(Set<? extends E>... sets) {
        Set<E> temp = new HashSet<>();
        temp.addAll(sets[0]);
        for(Set<? extends E> s : sets){
            temp.retainAll(s);
        }
        return temp;
    }


}
