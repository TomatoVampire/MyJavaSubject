package EXP2;

import java.util.ArrayList;
import java.util.List;

public abstract class SparseMap implements Sparse
{
    List<Triplet> matrix;

    public SparseMap(){
        matrix = new ArrayList();
        //matrix.add()
    }

    @Override
    public void addElement(int i,int j,double val){
        matrix.add( new Triplet(i,j,val));
    }
    @Override
    public int NonZeroCount(){
        return matrix.size();
    }
    @Override
    public String toString(){
        String temp = "";
        for(Triplet t : matrix){
            temp += "(" + t.refa + ", " +t.refb +", "+t.refc +")\n";
        }
        return temp;
    }
}
