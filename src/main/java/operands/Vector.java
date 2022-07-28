package operands;

import java.util.Arrays;

public class Vector extends Var {

    private final double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = value.clone();
    }


    @Override
    public Var add(Var other) {
        double[] result = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < result.length; i++) {
                result[i] += scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] += vector.value[i];
            }
            return new Vector(result);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        double[] result = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < result.length; i++) {
                result[i] -= scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] -= vector.value[i];
            }
            return new Vector(result);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        double[] result = value.clone();
        if (other instanceof Scalar scalar) {
            for (int i = 0; i < result.length; i++) {
                result[i] *= scalar.getValue();
            }
            return new Vector(result);
        } else if (other instanceof Vector vector) {
            for (int i = 0; i < result.length; i++) {
                result[i] *= vector.value[i];
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            if (scalar.getValue() != 0) {
                double[] result = value.clone();
                for (int i = 0; i < result.length; i++) {
                    result[i] /= scalar.getValue();
                }
                return new Vector(result);
            }
        }
        return super.div(other);
    }

    @Override
    public String getVarType() {
        return this.getClass().getName();
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }
}
