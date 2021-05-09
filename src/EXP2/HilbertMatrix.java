package EXP2;

public class HilbertMatrix {
    int row;
    DenseMatrix matrix;
    public HilbertMatrix(int num){
        row = num;
        matrix = new DenseMatrix(num,num);
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                double val = 1.0/(i+j-1);
                matrix.setValue(i,j,val);
            }
        }
    }
    @Override
    public String toString(){
        return matrix.toString();
    }

    public double getValue(int i,int j){
        return matrix.getValue(i,j);
    }
    public int rows(){
        return  row;
    }
    public int columns(){
        return row;
    }
    public void cholesky(){
        System.out.println("executing cholesky method...");
    }

}
