package EXP2;

public class SparseCompressed extends SparseMap{
    boolean operated;
    public SparseCompressed(){
        super();
        operated = false;
    }
    public void Compress(){
        System.out.println("compressing sparse matrix...");
        operated = true;
    }
    @Override
    public boolean IsCompressed(){
        return  operated;
    }
}
