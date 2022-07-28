package operands;

import java.util.Arrays;

public class Matrix extends Var{

    private final double[][] value;

    public Matrix(double[][] value) {
        this.value = value;
    }

    public double[][] getValue() {
        return value;
    }

    @Override
    public Var add(Var other) {
        double[][] result = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] += matrix.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        double[][] result = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] -= matrix.value[i][j];
                }
            }
            return new Matrix(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[][] result = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= scalar.getValue();
                }
            }
            return new Matrix(result);
        } else if (other instanceof Matrix matrix) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= matrix.value[i][j];
                }
            }
            return new Matrix(result);
        } else if (other instanceof Vector vector) {
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[i].length; j++) {
                    result[i][j] *= vector.getValue()[j];
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            if (scalar.getValue() != 0) {
                double[][] result = value.clone();
                for (int i = 0; i < result.length; i++) {
                    for (int j = 0; j < result[i].length; j++) {
                        result[i][j] /= scalar.getValue();
                    }
                }
                return new Matrix(result);
            }
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return Arrays.deepToString(value);
    }

    @Override
    public String getVarType() {
        return this.getClass().getName();
    }
}
