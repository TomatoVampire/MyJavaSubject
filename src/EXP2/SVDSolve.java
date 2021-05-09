package EXP2;

public interface SVDSolve<T> extends Solve<T>,Decompose<T>{
    public T compute(T mat);
    public void SVD();
    public T getU();
    public T getSigma();
    public T getV();
}
