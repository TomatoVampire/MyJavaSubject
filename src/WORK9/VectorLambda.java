package WORK9;
import java.util.function.BinaryOperator;

public class VectorLambda {
    public static void main(String[] args){
        Vector3 a = new Vector3(1,2,3);
        Vector3 b = new Vector3(4,5,6);
        for(VectorOperation op :VectorOperation.values()){
            System.out.println(a.toString()+op.toString()+b.toString()+"="+op.apply(a,b).toString());
        }
    }
}

class Vector3{
    public double x,y,z;
    public Vector3(double x,double y,double z){this.x=x;this.y=y;this.z=z;}
    @Override
    public String toString(){
        return "(" + x + ", " + y + ", " + z +")";
    }
}

enum VectorOperation{
    ADD("+",    (a,b)->new Vector3(a.x+b.x,a.y+b.y,a.z+b.z)),
    SUB("-",    (a,b)->new Vector3(a.x-b.x,a.y-b.y,a.z-b.z)),
    CROSS("x",   (a,b)->new Vector3(a.y*b.z - a.z*b.y,a.z*b.x-a.x*b.z,a.x*b.y-a.y*b.x));

    private final BinaryOperator<Vector3> op;
    private final String symbol;

    @Override public String toString(){return symbol;}
    VectorOperation(String s,BinaryOperator<Vector3> o){
        op = o;
        symbol = s;
    }


    public Vector3 apply(Vector3 x,Vector3 y){
        return op.apply(x,y);
    }
}