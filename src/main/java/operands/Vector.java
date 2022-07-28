package operands;

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
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public String getVarType() {
        return null;
    }
}
