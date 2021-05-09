package EXP2;

public class SparseMatrix extends SparseMap implements SVDSolve<SparseMatrix>{
    public SparseMatrix(){
        super();
    }
    public SparseMatrix(SparseMatrix r){
        for(int i=0;i<r.NonZeroCount();i++){
            //挨个复制三元组
            matrix.add(new Triplet(r.matrix.get(i)));
        }
    }
    @Override
    public boolean IsCompressed(){
        return false;
    }

    @Override
    public String toString(){
        String temp = "Compressed:"+IsCompressed()+"\n";
        temp += super.toString();
        return temp;
    }

    //SVD
    @Override
    public SparseMatrix[] decompose(int num) {
        SparseMatrix[] n = new SparseMatrix[num];
        for(int i=0;i<num;i++){
            //复制构造
            n[i] = new SparseMatrix(this);
        }
        System.out.println("sparse decomposing matrix...");
        return n;
    }

    @Override
    public SparseMatrix compute(SparseMatrix mat) {
        System.out.println("sparse computing matrix...");
        return mat;
    }

    @Override
    public void SVD() {
        System.out.println("sparse doing SVD operation to matrix...");
    }

    @Override
    public SparseMatrix getU() {
        System.out.println("sparse getting U...");
        return this;
    }

    @Override
    public SparseMatrix getSigma() {
        System.out.println("sparse getting sigma...");
        return this;
    }

    @Override
    public SparseMatrix getV() {
        System.out.println("sparse getting V...");
        return this;
    }

    @Override
    public SparseMatrix solve(SparseMatrix mat) {
        System.out.println("sparse solving matrix...");
        return mat;
    }
}
