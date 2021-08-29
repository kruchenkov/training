package domain;

public class Gun extends Chars{
    public Gun() {
        super("Gun caliber");
    }

    private String caliber;

    @Override
    public void setValue(String value) {
        caliber = value;
    }

    @Override
    public String getValue() {
        return caliber;
    }
}
