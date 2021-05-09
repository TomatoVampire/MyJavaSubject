package EXP2;

public class Triplet {
    public double refa;
    public double refb;
    public double refc;
    public Triplet(int a,int b,double c){
        refa = a;
        refb = b;
        refc = c;
    }

    public Triplet(Triplet r){
        refa = r.refa;
        refb = r.refb;
        refc = r.refc;
    }
}
