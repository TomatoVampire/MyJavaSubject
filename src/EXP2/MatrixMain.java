package EXP2;

public class MatrixMain {
    public static void main(String[] args)
    {
        //1
        DenseMatrix m1 = new DenseMatrix(3,3, 1,1,1);
        System.out.println(m1);
        System.out.println(m1.hashCode());
        //2
        ConstMatrix mc = new ConstMatrix(2,2,0,1,1,0);
        System.out.println(mc);
        //3
        SparseMatrix m2 = new SparseMatrix();
        m2.addElement(1,1,2);
        System.out.println(m2);
        SparseCompressed m2c = new SparseCompressed();
        m2c.addElement(1,1,3);
        m2c.Compress();
        System.out.println(m2c.IsCompressed());
        System.out.println("");
        //4
        m1.compute(m1);
        m1.decompose(2);
        m1.getSigma();
        m1.getU();
        m1.getV();

        m2.compute(m2);
        m2.decompose(2);
        m2.getSigma();
        m2.getU();
        m2.getV();

        //5
        HilbertMatrix m3 = new HilbertMatrix(5);
        System.out.println(m3);
        System.out.println(m3.getValue(1,1));
        m3.cholesky();
    }
}
