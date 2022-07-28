import operands.Matrix;
import operands.Scalar;
import operands.Var;
import operands.Vector;

public class Runner {
    public static void main(String[] args) {
        Var var1 = new Scalar(3);
        Var var2 = new Scalar(1);
        Var var3 = new Vector(new double[]{1, 2, 3});
        Var var4 = new Vector(new double[]{1, 1, 1,});

        Var var5 = new Matrix(new double[][]{{3, 6, 9},{12, 15, 18}});
        Var var6 = new Matrix(new double[][]{{1, 1, 1},{1, 1, 1}});



    }
}
