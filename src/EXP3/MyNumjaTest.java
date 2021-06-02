package EXP3;

public class MyNumjaTest {
    public static void main(String[] args) {
        //3行2列的数组
        MyNumJa.D2Array<Integer> m = new MyNumJa.D2Array<>(3,2);
        m.putAll(MyNumJa.Axis.ROW,1,3,4,2,8,5);
        System.out.println(m.array2String(MyNumJa.Axis.ROW));

        //是否有该元素
        System.out.println("数组内是否含有元素1："+m.contains(1));

        //输出数组的大小
        System.out.println(m.getSize());
        Integer[] temp = new Integer[6];
        System.out.println(array2str(m.toArray(temp, MyNumJa.Axis.ROW)));

        //输出按大小排列序号（列）
        System.out.println(m.argsort(MyNumJa.Axis.ROW).array2String(MyNumJa.Axis.ROW));
        System.out.println(m.argsort(MyNumJa.Axis.COLUMN).array2String(MyNumJa.Axis.ROW));
        //amin方法/amax
        temp = new Integer[6];
        System.out.println(array2str(MyNumJa.amin(m,MyNumJa.Axis.COLUMN,temp)));
        System.out.println(array2str(MyNumJa.amin(m,MyNumJa.Axis.ROW,temp)));
        temp = new Integer[6];
        System.out.println(array2str(MyNumJa.amax(m,MyNumJa.Axis.COLUMN,temp)));
        System.out.println(array2str(MyNumJa.amax(m,MyNumJa.Axis.ROW,temp)));
        //System.out.println(MyNumJa.amax(m,MyNumJa.Axis.COLUMN,temp));


        MyNumJa.D2Array<Integer> n = new MyNumJa.D2Array<>(3,2);
        n.putAll(MyNumJa.Axis.ROW,1,2,3,4,5,6);
        System.out.println(n.array2String(MyNumJa.Axis.ROW));
        //按行、列拼接数组
        System.out.println(MyNumJa.concatenate(m,n, MyNumJa.Axis.ROW).array2String(MyNumJa.Axis.ROW));
        //System.out.println(MyNumJa.concatenate(m,n, MyNumJa.Axis.COLUMN).array2String(MyNumJa.Axis.ROW));
    }
    public static<E> String array2str(E[] a){
        String temp = "[";
        for (E t : a){
            if(t != null) temp += t.toString() + " ";
        }
        temp += "]";
        return temp;
    }
}
