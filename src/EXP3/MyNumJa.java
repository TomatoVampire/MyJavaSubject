package EXP3;

import java.util.List;

public class MyNumJa {
    //行：数组 列：list容器
    public MyNumJa(){
    }

    public static class D2Array<E extends Comparable<E>>{
        private MyArray[] d2array;
        private int row;
        private int column;
        public D2Array(int row,int column){
            this.row = row;
            this.column = column;
            if(row==0 || column==0) throw new IllegalArgumentException("二维数组行列参数不可为0！");
            d2array = new MyArray[row];
            for(int i=0;i<row;i++){
                d2array[i] = new MyArray(column);
            }
        }
        public D2Array(D2Array ref){
            this(ref.row,ref.column);
            //for(int i=0;i<row;i++)
        }
        public int getRow(){return row;}
        public int getColumn(){return column;}
        public Vec2Int getSize(){
            return new Vec2Int(row,column);
        }
        public void putAll(Axis axis,E first,E... elements){
            if(elements.length < row*column-1) {System.out.println("参数数量必须为整个二维数组的元素数！");return;}
            put(0,0,first);
            if(axis == Axis.ROW)
            {
                for(int i=0,count=0;i<row;i++){
                    for(int j=0;j<column;j++){
                        if(i==0 && j==0) continue;
                        put(i,j,elements[count]);
                        count++;
                    }
                }
            }
            else{
                for(int j=0,count=0;j<column;j++){
                    for(int i=0;i<row;i++){
                        if(i==0 && j==0) continue;
                        put(i,j,elements[count]);
                        count++;
                    }
                }
            }
        }
        //放入单个元素
        public void put(int i,int j,E element){
            if(i >= row || i < 0 || j >= column || j < 0) throw new IllegalArgumentException("参数越界！");
            if(element == null) throw new NullPointerException("放入元素的参数不可为空！");
            d2array[i].set(j,element);
        }

        public void set(int i,int j,E element){
            put(i,j,element);
        }

        public E get(int i,int j){
            if(i >= row || i < 0 || j>= column || j < 0){
                throw new IllegalArgumentException("MyNumJa: index out of range!");
            }
            E temp = (E)d2array[i].get(j);
            if(temp == null) throw new NullPointerException("出错！访问坐标(" + i + ", "+j+")处返回为null!");
            return temp;
        }

        public Vec2Int get(E e){
            for(int i=0;i<row;i++) {
                for(int j=0;j<column;j++){
                    E temp = (E)d2array[i].get(j);
                    if(temp.equals(e)) return new Vec2Int(i,j);
                }
            }
            System.out.println("Error! Element not found in 2darray! ");
            return null;
        }

        public boolean contains(E e){
            for(int i=0;i<row;i++) {
                for(int j=0;j<column;j++){
                    E temp = (E)d2array[i].get(j);
                    if(temp.equals(e)) return true;
                }
            }
            return false;
        }

        public E[] toArray(E[] a,Axis axis)//0行1列
        {
            if(a == null) throw new NullPointerException();
            if(a.length < row*column) throw new IllegalArgumentException("参数数组大小过小！");
            int pointer = 0;
            if(axis == Axis.ROW){
                for(int i=0;i<row;i++){
                    for(int j=0;j<column;j++){
                        a[pointer] = get(i,j);
                        pointer++;
                    }
                }
            }
            else{
                for(int j=0;j<column;j++){
                    for(int i=0;i<row;i++){
                        a[pointer] = get(i,j);
                        pointer++;
                    }
                }
            }
            return a;
        }
        public E[] toArray(E[] a,int axis)//0行1列
        {
            if(axis == 0) return toArray(a,Axis.ROW);
            else if(axis == 1) return toArray(a,Axis.COLUMN);
            else throw new IllegalArgumentException("输入轴必须为0或1！");
        }

        //返回以二维数组的行/列参数比较从大到小的索引号
        public D2Array<Integer> argsort(Axis axis){
            D2Array<Integer> temp;
            if(axis == Axis.ROW){
                //初始化
                temp = new D2Array<>(row,column);
                Integer count = 0;//必须使用装箱类……
                for(int i=0;i<row;i++){
                    for(int j=0;j<column;j++){
                        temp.put(i,j,count);
                        count++;
                    }
                    count=0;
                }
                //System.out.println(temp.array2String(Axis.ROW));
                //开始排序
                for(int i=0;i<row;i++){
                    //每行进行冒泡排序？
                    for(int j=0;j<column;j++){
                        for(int m=0;m<j && m < column-1;m++){
                            //对于temp的相邻两个比较，若小于则交换temp的两个
                            if(get(i,temp.get(i,m)).
                                    compareTo(get(i,temp.get(i,m+1))) > 0){
                                //小于，交换temp的两个
                                Integer flag = temp.get(i,m);
                                temp.set(i,m,temp.get(i,m+1));
                                temp.set(i,m+1,flag);
                            }
                        }//m
                    }//j
                }
            }
            else{
                //初始化
                temp = new D2Array<>(column,row);
                Integer count = 0;//必须使用装箱类……
                for(int i=0;i<column;i++){
                    for(int j=0;j<row;j++){
                        temp.put(i,j,count);
                        count++;
                    }
                    count=0;
                }
                //开始排序
                for(int i=0;i<column;i++){
                    //每行进行冒泡排序？
                    for(int j=0;j<row;j++){
                        for(int m=0;m<j && m < row-1;m++){
                            //对于temp的相邻两个比较，若小于则交换temp的两个
                            if(get(temp.get(i,m),i).
                                    compareTo(get(temp.get(i,m+1),i)) > 0){
                                //小于，交换temp的两个
                                Integer flag = temp.get(i,m);
                                temp.set(i,m,temp.get(i,m+1));
                                temp.set(i,m+1,flag);
                            }
                        }//m
                    }//j
                }
            }
            return temp;
        }

        //将行列重新分配空间，但是需要重新初始化了
        public void rearrange(int r,int col){
            this.row = r;
            this.column = col;
            d2array = new MyArray[row];
            for(int i=0;i<row;i++){
                d2array[i] = new MyArray(column);
            }
        }

        public String array2String(Axis axis){
            String temp = "";
            if(axis == Axis.ROW) {
                for (int i = 0; i < row; i++) {
                    for (int j = 0;j < column; j++) {
                        temp += get(i, j).toString() + " ";
                    }
                    temp += "\n";
                }
            }
            else{
                for (int j = 0; j < column; j++) {
                    for (int i = 0;i < row; i++) {
                        temp += get(i, j).toString() + " ";
                    }
                    temp += "\n";
                }
            }
            return temp;
        }
    }
    public static class MyArray{
        private Object[] array;
        private int size;
        public MyArray(int size){
            this.size = size;
            array = new Object[size];
        }
        public void set(int i, Object o){
            if(i >= size || i < 0) throw new IllegalArgumentException();
            array[i] = o;
        }
        public Object get(int i){
            return array[i];
        }
    }
    public static enum Axis{
        ROW("ROW"),
        COLUMN("COLUMN");
        public final String content;
        Axis(String s) {content = s;}
        @Override public String toString(){return content;}
    }

    //获取D2Array按指定轴的最小值
    public static <E extends Comparable<E>> E[] amin(D2Array<E> array, Axis axis, E[] store){
        //每一行的最小值，返回一个数组？
        int count = 0;
        if(axis == Axis.ROW){
            if(store.length < array.getRow()) throw new IllegalArgumentException("给的数组容器大小过小！");
            for(int i=0;i< array.row;i++){
                E min = array.get(i,0);
                for(int j=0;j< array.column;j++){
                    if(min.compareTo(array.get(i,j)) > 0) min = array.get(i,j);
                }
                store[count++] = min;
            }
        }
        else{
            if(store.length < array.getColumn()) throw new IllegalArgumentException("给的数组容器大小过小！");
            for(int j=0;j< array.column;j++){
                E min = array.get(0,j);
                for(int i=0;i< array.row;i++){
                    if(min.compareTo(array.get(i,j)) > 0) min = array.get(i,j);
                }
                store[count++] = min;
            }
        }
        return store;
    }

    //获取D2Array按指定轴的最大值
    public static <E extends Comparable<E>> E[] amax(D2Array<E> array, Axis axis, E[] store){
        //每一行的最小值，返回一个数组？
        int count = 0;
        if(axis == Axis.ROW){
            if(store.length < array.getRow()) throw new IllegalArgumentException("给的数组容器大小过小！");
            for(int i=0;i< array.row;i++){
                E max = array.get(i,0);
                for(int j=0;j< array.column;j++){
                    if(max.compareTo(array.get(i,j)) < 0) max = array.get(i,j);
                }
                store[count++] = max;
            }
        }
        else{
            if(store.length < array.getColumn()) throw new IllegalArgumentException("给的数组容器大小过小！");
            for(int j=0;j< array.column;j++){
                E max = array.get(0,j);
                for(int i=0;i< array.row;i++){
                    if(max.compareTo(array.get(i,j)) < 0) max = array.get(i,j);
                }
                store[count++] = max;
            }
        }
        return store;
    }

    //将第一个矩阵与第二个连接，会更改第一个矩阵！
    //行连接：要求行数相等
    //列连接：要求列数相等
    public static<E extends Comparable<E>> D2Array<E> concatenate(D2Array<E> a1, D2Array<E> a2,Axis axis){
        if(axis == Axis.ROW) {
            //行连接：newrow = row, newcol = a1.col+a2.col
            int nrow = a1.row;
            int ncolum = a1.column+ a2.column;
            if(a1.row != a2.row) throw new IllegalArgumentException("出错！行连接时，两矩阵的行数不相等！");
            //临时保存矩阵
            Object[][] temparray = new Object[nrow][ncolum];
            for(int i=0;i<nrow;i++){
                for(int j=0;j<ncolum;j++) {
                    if(j < a1.column) temparray[i][j] = a1.get(i,j);
                    else temparray[i][j] = a2.get(i,j- a1.column);
                }
            }
            a1.rearrange(nrow,ncolum);
            for(int i=0;i<nrow;i++){
                for(int j=0;j<ncolum;j++) {
                    a1.set(i,j,(E)temparray[i][j]);
                }
            }
        }
        else{
            int nrow = a1.row+ a2.row;
            int ncolum = a1.column;
            if(a1.column != a2.column) throw new IllegalArgumentException("出错！列连接时，两矩阵的列数不相等！");
            //临时保存矩阵
            Object[][] temparray = new Object[nrow][ncolum];
            for(int i=0;i<nrow;i++){
                for(int j=0;j<ncolum;j++) {
                    if(i < a1.row) temparray[i][j] = a1.get(i,j);
                    else temparray[i][j] = a2.get(i- a1.row,j);
                }
            }
            a1.rearrange(nrow,ncolum);
            for(int i=0;i<nrow;i++){
                for(int j=0;j<ncolum;j++) {
                    a1.set(i,j,(E)temparray[i][j]);
                }
            }
        }
        return a1;
    }

}
