package EXP2;
public interface Sparse
{
    void addElement(int i,int j,double val);
    int NonZeroCount();
    boolean IsCompressed();
}
