package WORK7;

public class VectorTest {
    public static void main(String[] args){
        Vector3 a = new Vector3(1,2,3);
        Vector3 b = new Vector3(4,5,6);
        for(VectorOperation v : VectorOperation.values()){
            System.out.println(v.apply(a,b));
        }
    }
}

class Vector3{
    double x;
    double y;
    double z;
    public Vector3(double a,double b,double c){
        this.x = a;
        this.y = b;
        this.z = c;
    }
    @Override
    public String toString(){
        return "(" + x + ", " + y + ", " + z +")";
    }
}

enum VectorOperation{
    ADD{
        public Vector3 apply(Vector3 a, Vector3 b){
            return new Vector3(a.x+b.x,a.y+b.y,a.z+b.z);
            }
        },
    SUB{
        public Vector3 apply(Vector3 a,Vector3 b){
            return new Vector3(a.x-b.x,a.y-b.y,a.z-b.z);
        }
    },
    CROSS{
        public Vector3 apply(Vector3 a,Vector3 b){
            return new Vector3(a.y*b.z - a.z*b.y,a.z*b.x-a.x*b.z,a.x*b.y-a.y*b.x);
        }
    };
    public abstract Vector3 apply(Vector3 a,Vector3 b);
}