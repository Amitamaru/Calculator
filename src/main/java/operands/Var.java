package operands;

public abstract class Var implements Operation{


    public abstract String getVarType();

    @Override
    public String toString() {
        return "abstract var";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is impossible", this, other);
        return null;
    }
}
