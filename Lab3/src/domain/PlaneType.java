package domain;

public class PlaneType extends Chars {
    public PlaneType() {
        super("Type of plane");
    }

    private Type type;

    @Override
    public void setValue(String value) {
        type = Type.valueOf(value);
    }

    @Override
    public String getValue() {
        return type.toString();
    }
}
