package operands;

public class Scalar extends Var{
    private final double value;

    public double getValue() {
        return value;
    }

    public Scalar(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value + scalar.value);
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value - scalar.value);
        }
        Scalar minus = new Scalar(-1);
        return other.sub(this).mul(minus);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar scalar) {
            return new Scalar(this.value * scalar.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar scalar) {
            if (scalar.value != 0) {
                return new Scalar(this.value / scalar.value);
            }
        }
        return super.div(other);
    }

    @Override
    public String getVarType() {
        return this.getClass().getName();
    }
}
