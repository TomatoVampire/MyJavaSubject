package EXP2;



public class DenseMatrix implements SVDSolve<DenseMatrix>{

    //使用二维数组存储稠密矩阵
    double[][] matrix;
    int row, column;

    public DenseMatrix(){
        this(10, 10);
    }

    public DenseMatrix(int row,int column){
        matrix = new double[row][column];
        this.row = row;
        this.column = column;
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
                matrix[i][j] = 0;
        }
    }

    public DenseMatrix(int row,int column, double... vals) {
        this(row,column);
        int count = vals.length;
        int i=0, j=0;
        for(double v : vals) {
            matrix[i][j] = v;
            i = j+1>=column ? i+1 : i;
            j = j+1>=column? 0 : j+1;
        }
    }

    //复制构造
    public DenseMatrix(DenseMatrix r){
        this(r.row,r.column);
        matrix = new double[row][column];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
                matrix[i][j] = r.matrix[i][j];
        }
    }

        public void setValue(int i, int j, double val) {
            if(i > row || i < 0 || j > column || j < 0) {System.out.println("matrix out of range!"); return;}
            matrix[i-1][j-1] = val;
        }

    public double getValue(int i,int j){
        if(i > row || i < 0 || j > column || j < 0) {System.out.println("matrix out of range!"); return -1.0;}
        return matrix[i-1][j-1];
    }

    @Override
    public String toString()
    {
        String str = "";
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<column;j++)
                str += matrix[i][j] + " ";

            str += "\n";
        }
        return str;
    }

    @Override
    public boolean equals(Object o){
        if(o == this) return true;
        if(o instanceof DenseMatrix){
            DenseMatrix od = (DenseMatrix) o;
            if(row != od.row || column != od.column) return false;
            for(int i=0;i<row;i++)
            {
                for(int j=0;j<column;j++)
                {
                    if(matrix[i][j] != od.matrix[i][j]) return false;
                }
            }
            return true;
        }
        else return false;
    }

    @Override
    public int hashCode()
    {
        int code = matrix.hashCode();
        code = 31 * code + Integer.hashCode(row);
        code = 31 * code + Integer.hashCode(column);
        return code;
    }

    //SVDSolve
    @Override
    public DenseMatrix[] decompose(int num) {
        DenseMatrix[] n = new DenseMatrix[num];
        for(int i=0;i<num;i++){
            //复制构造
            n[i] = new DenseMatrix(this);
        }
        System.out.println("dense decomposing matrix...");
        return n;
    }

    @Override
    public DenseMatrix compute(DenseMatrix mat) {
        System.out.println("dense computing matrix...");
        return mat;
    }

    @Override
    public void SVD() {
        System.out.println("dense doing SVD operation to matrix...");
    }

    @Override
    public DenseMatrix getU() {
        System.out.println("dense getting U...");
        return this;
    }

    @Override
    public DenseMatrix getSigma() {
        System.out.println("dense getting sigma...");
        return this;
    }

    @Override
    public DenseMatrix getV() {
        System.out.println("dense getting V...");
        return this;
    }

    @Override
    public DenseMatrix solve(DenseMatrix mat) {
        System.out.println("dense solving matrix...");
        return mat;
    }

}
