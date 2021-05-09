package EXP2;

public class ConstMatrix {
    private final DenseMatrix matrix;

    public ConstMatrix(int row,int column,double... vals) {
        matrix = new DenseMatrix(row,column,vals);
    }

    @Override
    public String toString(){
        return matrix.toString();
    }
}
